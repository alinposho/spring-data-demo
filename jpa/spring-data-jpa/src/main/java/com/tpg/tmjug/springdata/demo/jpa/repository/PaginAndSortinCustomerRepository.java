package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaginAndSortinCustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query("select c from Customer c where c.age >= ?1 and c.age <= ?2")
    List<Customer> findByAge(int start, int end);


    List<Customer> findByAgeGreaterThan(int start);

    List<Customer> findByAgeBetween(int start, int end);

    List<Customer> findByAgeAndName(int age, String name);

    List<Customer> findByNameAndAgeGreaterThan(String name, int start);

    Page<Customer> findByNameAndAgeGreaterThan(String name, int start, Pageable pageable);
}
