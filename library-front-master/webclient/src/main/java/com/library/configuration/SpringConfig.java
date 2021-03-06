package com.library.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.library")
@ImportResource("classpath:/applicationContext.xml")
public class SpringConfig {
}
