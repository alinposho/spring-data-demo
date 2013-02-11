package com.tpg.tmjug.springdata.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tpg.tmjug.springdata.demo.mongodb.model.User;


public interface UserRepository extends CrudRepository<User, String> {

	@Query("{ 'firstName': ?0 }")
 	public User findUserByName(String name);
	
}
