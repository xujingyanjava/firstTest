package com.first.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefaultView implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/getTopicList");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        WebMvcConfigurer.super.addViewControllers(registry);

    }
}
