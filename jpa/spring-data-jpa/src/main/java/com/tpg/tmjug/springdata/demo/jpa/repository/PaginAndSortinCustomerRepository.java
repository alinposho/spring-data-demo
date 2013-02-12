package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginAndSortinCustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
