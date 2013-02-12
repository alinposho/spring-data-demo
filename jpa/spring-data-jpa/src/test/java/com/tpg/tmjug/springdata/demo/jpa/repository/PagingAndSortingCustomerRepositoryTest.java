package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Address;
import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
public class PagingAndSortingCustomerRepositoryTest {

    @Autowired
    PaginAndSortinCustomerRepository paginAndSortinCustomerRepository;

    @Test
    public void should_save_and_retrieve_persisted_customer() {
        // Prepare
        List<Customer> customers = createDummyCustomers(9);

        // Exercise
        Pageable pageable = new PageRequest(0, 1, Sort.Direction.DESC, "name");
        Page<Customer> customerPage = paginAndSortinCustomerRepository.findAll(pageable);


        // Verify
        assertNotNull(customerPage);
        assertEquals(customerPage.getSize(), 1);
        assertEquals(customers.get(0), customerPage.getContent().get(0));
    }

    private List<Customer> createDummyCustomers(int numberOfDummyCustomers) {
        List<Customer> customers = new ArrayList<>();

        for(int i = 0; i < numberOfDummyCustomers; i++) {
            Customer customer = new Customer(new Long(i), "Doe", 21, new Address(new Long(i)));
            Customer savedCustomer = paginAndSortinCustomerRepository.save(customer);
            customers.add(customer);
        }

        return customers;
    }


}
