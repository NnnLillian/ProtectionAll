package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mappers")
@EnableCaching
//@ComponentScan(basePackages = {"com.example.service", "com.example.mappers", "com.example.controller","com.example.security"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
@Component
class WebConfigurer extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("fonts/**").addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("images/**").addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("baidumapv2/**").addResourceLocations("classpath:/static/baidumapv2/");
        registry.addResourceHandler("baidumapv2_demo/**").addResourceLocations("classpath:/baidumapv2_demo/baidumapv2/");
        registry.addResourceHandler("elementSuggest/**").addResourceLocations("classpath:/static/elementSuggest/");
        registry.addResourceHandler("sweetalert2/**").addResourceLocations("classpath:/static/sweetalert2/");
    }
}