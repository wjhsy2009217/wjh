package com.hzgc.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


@Configuration
public class FilterConfig {

    @Bean
    Filter myFilter(){
        return new MyFilter();
    }

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean1(){
        FilterRegistrationBean<MyFilter> filterRegistrationBean=new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter((MyFilter) myFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //filterRegistrationBean.setOrder();多个filter的时候order的数值越小 则优先级越高
        return filterRegistrationBean;
    }
}
