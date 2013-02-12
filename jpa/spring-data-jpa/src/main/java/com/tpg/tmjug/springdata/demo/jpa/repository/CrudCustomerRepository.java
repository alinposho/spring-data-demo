package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CrudCustomerRepository extends CrudRepository<Customer, Long> {

}
