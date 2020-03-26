package com.rpm.services.repository;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Profile("cloud")
public class CloudConfiguration {

  @Bean
  public Cloud cloud() {
    return new CloudFactory().getCloud();
  }

/*  @Bean
  public DataSource dataSource() {
    return cloud().getSingletonServiceConnector(DataSource.class, null);
  }*/
  
  @Bean
  public MongoDbFactory mongoDbFactory() {
      return cloud().getSingletonServiceConnector(MongoDbFactory.class, null);
  }

  @Bean
  public MongoTemplate mongoTemplate() {
      return new MongoTemplate(mongoDbFactory());
  }

}