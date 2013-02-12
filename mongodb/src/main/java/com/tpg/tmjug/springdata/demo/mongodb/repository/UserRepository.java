package com.tpg.tmjug.springdata.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tpg.tmjug.springdata.demo.mongodb.entity.MongoUser;


public interface UserRepository extends CrudRepository<MongoUser, String> {

	@Query("{ 'firstName': ?0 }")
 	public MongoUser findUserByName(String name);
	
}
