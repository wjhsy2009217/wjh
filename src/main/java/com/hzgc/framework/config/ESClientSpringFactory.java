package com.hzgc.framework.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ESClientSpringFactory {
    private static int CONNECT_TIMEOUT_MILLIS = 10000;
    private static int SOCKET_TIMEOUT_MILLIS = 300000;
    private static int CONNECTION_REQUEST_TIMEOUT_MILLIS = 5000;
    private static int MAX_CONN_PER_ROUTE = 10;
    private static int MAX_CONN_TOTAL = 30;

    private static HttpHost HTTP_HOST;
    private RestClientBuilder builder;
    private RestClient restClient;
    private RestHighLevelClient restHighLevelClient;

    private static ESClientSpringFactory esClientSpringFactory = new ESClientSpringFactory();

    private ESClientSpringFactory(){}

    public static ESClientSpringFactory build(HttpHost httpHost,
                                              Integer maxConnectNum, Integer maxConnectPerRoute){
        HTTP_HOST = httpHost;
        MAX_CONN_TOTAL = maxConnectNum;
        MAX_CONN_PER_ROUTE = maxConnectPerRoute;
        return  esClientSpringFactory;
    }

    public static ESClientSpringFactory build(HttpHost httpHost,Integer connectTimeOut, Integer socketTimeOut,
                                              Integer connectionRequestTime,Integer maxConnectNum, Integer maxConnectPerRoute){
        HTTP_HOST = httpHost;
        CONNECT_TIMEOUT_MILLIS = connectTimeOut;
        SOCKET_TIMEOUT_MILLIS = socketTimeOut;
        CONNECTION_REQUEST_TIMEOUT_MILLIS = connectionRequestTime;
        MAX_CONN_TOTAL = maxConnectNum;
        MAX_CONN_PER_ROUTE = maxConnectPerRoute;
        return  esClientSpringFactory;
    }


    public void init(){
        builder = RestClient.builder(HTTP_HOST);
        setConnectTimeOutConfig();
        setMutiConnectConfig();
        restClient = builder.build();
        restHighLevelClient = new RestHighLevelClient(builder);
        System.out.println("init factory");
    }
    // 配置连接时间延时
    public void setConnectTimeOutConfig(){
        builder.setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setConnectTimeout(CONNECT_TIMEOUT_MILLIS);
            requestConfigBuilder.setSocketTimeout(SOCKET_TIMEOUT_MILLIS);
            requestConfigBuilder.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT_MILLIS);
            return requestConfigBuilder;
        });
    }
    // 使用异步httpclient时设置并发连接数
    public void setMutiConnectConfig(){
        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            httpClientBuilder.setMaxConnTotal(MAX_CONN_TOTAL);
            httpClientBuilder.setMaxConnPerRoute(MAX_CONN_PER_ROUTE);
            return httpClientBuilder;
        });
    }

    public RestClient getClient(){
        return restClient;
    }

    public RestHighLevelClient getRhlClient(){
        return restHighLevelClient;
    }

    public void close() {
        if (restClient != null) {
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
