package com.mycompany.spring.rest.webservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mycompany.spring.rest.webservice")
public class HelloWorldConfiguration {

}