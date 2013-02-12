package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Address;
import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;

import java.util.List;

public interface JpaCustomerDAO {

    Customer findOne(Long id);

    Customer save(Customer customer);

    List<Customer> findByAddress(Address address);
}
