package com.tpg.tmjug.springdata.demo.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginAndSortinCustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
