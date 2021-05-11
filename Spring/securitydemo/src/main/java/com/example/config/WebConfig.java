package com.example.config;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {

    public void addView(ViewControllerRegistry registry){
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("/auth/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
