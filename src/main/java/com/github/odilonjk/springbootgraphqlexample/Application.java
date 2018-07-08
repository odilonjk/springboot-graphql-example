package com.github.odilonjk.springbootgraphqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@Configuration
@SpringBootApplication(scanBasePackages="com.github.odilonjk.springbootgraphqlexample")
@EnableJpaRepositories(basePackages="com.github.odilonjk.springbootgraphqlexample.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
