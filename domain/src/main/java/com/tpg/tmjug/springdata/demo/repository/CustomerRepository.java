package com.tpg.tmjug.springdata.demo.repository;

import com.tpg.tmjug.springdata.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
