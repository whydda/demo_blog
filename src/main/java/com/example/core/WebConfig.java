package com.example.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by whydd on 2017-03-03.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
            DefaultParamsArgumentResolver defaultParamsArgumentResolver = new DefaultParamsArgumentResolver();
            argumentResolvers.add(defaultParamsArgumentResolver);
        }
}
