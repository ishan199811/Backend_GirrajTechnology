package com.GirrajTechnology.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	  @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")  // Applies to all endpoints
	                        .allowedOriginPatterns("*") // ✅ Allows all origins safely
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
	                        .allowedHeaders("*")
	                        .allowCredentials(true); // Allows cookies and Authorization headers
	            }
	        };
	    }
	}
//.allowedOrigins("http://localhost:3000") // Add your Netlify domain
//.allowedOrigins("https://girrajtechnology.com") // Add your Netlify domain