package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.example.demo.intercpetor.BeforeActionInterceptor;

@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer{
	@Autowired
	BeforeActionInterceptor beforActionInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforActionInterceptor).addPathPatterns("/**");
		//모든 요청이 들어오기 전에 beforActionInterceptor를 활용하겠다.
	}
}
