package com.tpg.tmjug.springdata.demo.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.tpg.tmjug.springdata.demo.repository")
public class MongoUserConfig extends ApplicationConfig {

}
