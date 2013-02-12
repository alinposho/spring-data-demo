package com.tpg.tmjug.springdata.demo.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.repository.Repository;

import com.tpg.tmjug.springdata.demo.mongodb.entity.Customer;
 
public interface CustomerSearchRepository extends Repository<Customer, String> {

	public List<Customer> findByAgeGreaterThan(final int age);
	
	public List<Customer> findByLocation_PositionWithin(final Circle circle);
	
	public Page<Customer> findByAgeBetween(final int lowerBound, final int higherBound, final Pageable pageable);

	public List<Customer> findByNameLike(final String exp, final Sort sortable);

}
