package com.tpg.tmjug.springdata.demo.mongodb.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = { "com.tpg.tmjug.springdata.demo.mongodb.repository", "com.tpg.tmjug.springdata.demo.mongodb.model.converters" })
@EnableMongoRepositories(basePackages = "com.tpg.tmjug.springdata.demo.mongodb.repository")
public class BasicUserConfig extends ApplicationConfig {

	@Autowired
	private List<Converter<?, ?>> converters;
	
	@Override
	protected String getDatabaseName() {
		return "tmjug_db";
	}

	@Override
	public @Bean CustomConversions customConversions() {
		return new CustomConversions(converters);
	}

}
