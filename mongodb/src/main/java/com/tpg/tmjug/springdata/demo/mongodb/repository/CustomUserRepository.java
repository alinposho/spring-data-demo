package com.tpg.tmjug.springdata.demo.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.repository.Repository;

import com.tpg.tmjug.springdata.demo.mongodb.entity.MongoUser;
 
public interface CustomUserRepository extends Repository<MongoUser, String> {

	public List<MongoUser> findByAgeGreaterThan(final int age);
	
	public List<MongoUser> findByLocationWithin(final Circle circle);

}
