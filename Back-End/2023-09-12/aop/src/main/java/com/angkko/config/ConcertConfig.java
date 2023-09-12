package com.angkko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.angkko.concert.Audience;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = { "com.angkko.concert" })
public class ConcertConfig {
	@Bean
	public Audience audience() {
		return new Audience();
	}
}
