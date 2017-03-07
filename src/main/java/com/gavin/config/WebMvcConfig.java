package com.gavin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2017-03-06
 * Time: 13:59
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    protected static final String TAG = "WebMvcConfig";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/welcome").setViewName("/welcome");
        registry.addViewController("/demo").setViewName("/demo");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/chat").setViewName("/chat");
    }
}
