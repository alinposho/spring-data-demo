package com.tpg.tmjug.springdata.demo.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.tpg.tmjug.springdata.demo.jpa.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
