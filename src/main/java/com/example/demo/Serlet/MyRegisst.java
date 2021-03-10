package com.example.demo.Serlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

@Configuration(proxyBeanMethods = true)//默认为true，保证依赖的组件始终是单实例的
public class MyRegisst {
    @Bean
    public ServletRegistrationBean myServlet(){
        SerletController myServlet=new SerletController();
        return new ServletRegistrationBean(myServlet,"/my");
    }
//    @Bean
//    public FilterRegistrationBean myFilter() {
//        MyFilter myFilter = new MyFilter();
//        //return new FilterRegistrationBean(myFilter,myServlet());//拦截servlet规定路径
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));
//        return filterRegistrationBean;
//    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
         MySerletContestListener mySerletContestListener = new MySerletContestListener();
         return new ServletListenerRegistrationBean(mySerletContestListener);
     }
}




