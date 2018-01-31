package com.mie.fang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.mie.util.PropertyPlaceholderUtil;

@Configuration
public class PropertyConfig {
	@Bean
    public PropertyPlaceholderUtil propertyPlaceholderUtil() {  
		PropertyPlaceholderUtil propertyPlaceholderUtil=new PropertyPlaceholderUtil();
		ClassPathResource configpath=new ClassPathResource("config.properties");
		propertyPlaceholderUtil.setLocation(configpath);
		return propertyPlaceholderUtil;
	}
}
