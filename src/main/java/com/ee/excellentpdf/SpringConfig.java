package com.ee.excellentpdf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Service
@Configuration("com.ee.excellentpdf")
@EnableWebMvc
@EnableScheduling
public class SpringConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("/styles/");
        registry.addResourceHandler("/html/**").addResourceLocations("/","**");
    }

}
