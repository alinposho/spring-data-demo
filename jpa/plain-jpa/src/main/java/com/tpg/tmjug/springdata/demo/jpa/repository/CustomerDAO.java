package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Address;
import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.springframework.data.repository.Repository;

public interface CustomerDAO extends Repository<Customer, Long> {

    Customer findOne(Long id);

    Customer save(Customer customer);

    Customer findByAddress(Address address);
}
