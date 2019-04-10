package com.library.batch.scheduler;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@PropertySource("classpath:batch.properties")
@ComponentScan("com.library")
public class AppConfiguration extends DefaultBatchConfigurer {
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
  @Override
  public void setDataSource(DataSource dataSource) {
    //This BatchConfigurer ignores any DataSource
  }
}
