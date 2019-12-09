package com.tw.listener_filter_interceptor_aspect_lifecycle;

import com.tw.listener_filter_interceptor_aspect_lifecycle.filter.CustomFilterA;
import com.tw.listener_filter_interceptor_aspect_lifecycle.interceptor.CustomInterceptorA;
import com.tw.listener_filter_interceptor_aspect_lifecycle.interceptor.CustomInterceptorB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-07 20:10
 */
@SpringBootApplication
@Configuration
@ServletComponentScan(basePackages = {"com.tw.listener_filter_interceptor_aspect_lifecycle"})
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    @Order(1)
    public FilterRegistrationBean customFilterA() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setEnabled(true);
        registration.setFilter(new CustomFilterA());
        registration.addUrlPatterns("/*");
        return registration;
    }

//    @Bean
//    @Order(2)
//    public FilterRegistrationBean customFilterB() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setEnabled(true);
//        registration.setFilter(new CustomFilterB());
//        registration.addUrlPatterns("/*");
//        return registration;
//    }

    @Configuration
    abstract class InterceptorConfig implements WebMvcConfigurer {
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new CustomInterceptorA()).addPathPatterns("/**");
            registry.addInterceptor(new CustomInterceptorB()).addPathPatterns("/**");
        }
    }
}
