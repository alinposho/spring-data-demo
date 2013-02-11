package com.tpg.tmjug.springdata.demo.mongodb.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan(basePackages = { "com.tpg.tmjug.springdata.demo.mongodb.repository", "com.tpg.tmjug.springdata.demo.mongodb.model.converters" })
@EnableMongoRepositories(basePackages = "com.tpg.tmjug.springdata.demo.mongodb.repository")
public class UserTestConfig extends AbstractMongoConfiguration {

	@Autowired
	private List<Converter<?, ?>> converters;
	
	@Override
	protected String getDatabaseName() {
		return "tmjug_db";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		Mongo mongo = new Mongo();
		mongo.setWriteConcern(WriteConcern.SAFE);

		return mongo;
	}

	@Override
	public @Bean SimpleMongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), getDatabaseName());
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		mongoTemplate.setWriteResultChecking(WriteResultChecking.LOG);

		return mongoTemplate;
	}

	@Override
	public @Bean CustomConversions customConversions() {
		return new CustomConversions(converters);
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.tpg.tmjug.springdata.demo.mongodb.model";
	}	
}
