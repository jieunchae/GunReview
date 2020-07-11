package com.mnd.gunreview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

import com.mnd.interceptor.AuthInterceptor;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor())
		.addPathPatterns("/**");
		//.excludePathPatterns("/css/**");
		//위에 제외할 로그인 api 경로 넣으삼
	}
	
}
