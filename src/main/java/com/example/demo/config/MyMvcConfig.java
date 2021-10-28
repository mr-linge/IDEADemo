package com.example.demo.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.compoment.LoginInterceptor;
import com.example.demo.compoment.MyLocalResolver;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //当访问 “/” 或 “/index.html” 时，都直接跳转到登陆页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        //添加视图映射 main.html 指向  dashboard.html
        registry.addViewController("/main.html").setViewName("main");
    }
    //将自定义的区域信息解析器以组件的形式添加到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
     //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册拦截器");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/", "/login", "/index.html","/registration.html", "/user/login", "/css/**", "/images/**", "/js/**", "/fonts/**","/favico.ico"); // 放行特定的请求

    }
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws  Exception{
        DruidDataSource druidDataSource = new DruidDataSource();
        return  druidDataSource;
    }
}

