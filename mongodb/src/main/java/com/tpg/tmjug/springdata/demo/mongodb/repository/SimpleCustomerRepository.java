package com.tpg.tmjug.springdata.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tpg.tmjug.springdata.demo.mongodb.entity.Customer;

public interface SimpleCustomerRepository extends CrudRepository<Customer, String> {

	@Query("{ 'name': ?0 }")
 	public Customer getByName(String name);
	
}
