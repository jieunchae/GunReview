package com.mnd.gunreview.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.mnd.gunreview.dao"
)
public class DatabaseConfig {}