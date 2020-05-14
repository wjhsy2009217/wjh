package com.hzgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 启动程序
 * 
 * @author zyd
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ServletComponentScan(basePackages = "com.hzgc.filter")
@MapperScan("com.hzgc.project.*.*.mapper")
public class Application
{
    @Configuration
    public class InterceptorConfig implements WebMvcConfigurer {

        @Autowired
        SessionTimeoutInterceptor sessionTimeoutInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(sessionTimeoutInterceptor)
            // 添加不拦截的请求
            .excludePathPatterns("/login","/doLogin","/getYZM","/user/updateLoginError","/checkYZM",
                            "/**/*.css","/**/*.js","/**/*.png","/**/*.gif","/**/*.jpg","/**/*.jpeg");
        }
    }
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        System.err.println("平治运营数据中心启动成功!");
    }
}