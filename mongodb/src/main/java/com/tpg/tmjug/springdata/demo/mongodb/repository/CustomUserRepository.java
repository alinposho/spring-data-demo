package com.tpg.tmjug.springdata.demo.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.repository.Repository;

import com.tpg.tmjug.springdata.demo.mongodb.model.User;
 
public interface CustomUserRepository extends Repository<User, String> {

	public List<User> findByAgeGreaterThan(final int age);
	
	public List<User> findByLocationWithin(final Circle circle);

}
