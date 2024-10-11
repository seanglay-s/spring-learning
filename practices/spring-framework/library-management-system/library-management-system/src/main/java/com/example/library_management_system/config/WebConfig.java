package com.example.library_management_system.config;

import com.example.library_management_system.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor(); // Create a new instance of your interceptor
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor()).addPathPatterns("/**"); // Apply to all paths
    }
}