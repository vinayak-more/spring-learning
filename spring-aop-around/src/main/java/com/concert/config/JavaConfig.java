package com.concert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.concert.Concert;
import com.concert.audience.Audience;

@Configuration
@ComponentScan(basePackageClasses={Concert.class})
@EnableAspectJAutoProxy
public class JavaConfig {

	@Bean
	public Audience audience(){
		return new Audience();
	}
}
