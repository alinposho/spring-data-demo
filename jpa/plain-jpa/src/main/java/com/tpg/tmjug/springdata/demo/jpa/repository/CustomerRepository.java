package com.tpg.tmjug.springdata.demo.jpa.repository;

import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long> {

    Customer findOne(Long id);

    Customer save(Customer customer);

    Customer findByAddress(Address address);
}
