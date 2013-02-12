package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Address;
import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;

public interface JpaCustomerDAO {

    Customer findOne(Long id);

    Customer save(Customer customer);

    Customer findByAddress(Address address);
}
