package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Address;
import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
@Transactional
public class PagingAndSortingCustomerRepositoryTest {

    public static final String DUMMY_CUSTOMER_NAME = "Doe";
    @Autowired
    PaginAndSortinCustomerRepository paginAndSortinCustomerRepository;

    @After
    public void cleanUp() {
        paginAndSortinCustomerRepository.deleteAll();
    }

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

    @Test
    public void findByAttributeAndValue_should_retrieve_the_customers_filtered_by_age() {
        // Prepare
        int numberOfDummyCustomers = 9;
        List<Customer> customers = createDummyCustomers(numberOfDummyCustomers);

        // Exercise
        List<Customer> filteredCustomers = paginAndSortinCustomerRepository.findByAge(1, numberOfDummyCustomers);


        // Verify
        assertNotNull(filteredCustomers);
        assertEquals(numberOfDummyCustomers - 1, filteredCustomers.size());
        assertTrue("The list of customers is filtered by age", customers.containsAll(filteredCustomers));

    }

    @Test
    public void findByAttributeAndValue_should_retrieve_the_customers_starting_with_age() {
        // Prepare
        int numberOfDummyCustomers = 9;
        List<Customer> customers = createDummyCustomers(numberOfDummyCustomers);

        // Exercise
        List<Customer> filteredCustomers = paginAndSortinCustomerRepository.findByAgeGreaterThan(2);


        // Verify
        assertNotNull(filteredCustomers);
        assertEquals(numberOfDummyCustomers - 3, filteredCustomers.size());
        assertTrue("The list of customers is filtered by age", customers.containsAll(filteredCustomers));

    }

    @Test
    public void findByAttributeAndValue_should_retrieve_the_customers_between_specific_age_values() {
        // Prepare
        int numberOfDummyCustomers = 9;
        List<Customer> customers = createDummyCustomers(numberOfDummyCustomers);

        // Exercise
        List<Customer> filteredCustomers = paginAndSortinCustomerRepository.findByAgeBetween(1, numberOfDummyCustomers);


        // Verify
        assertNotNull(filteredCustomers);
        assertEquals(numberOfDummyCustomers - 1, filteredCustomers.size());
        assertTrue("The list of customers is filtered by age", customers.containsAll(filteredCustomers));

    }

    @Test
    public void findByAttributeAndValue_should_retrieve_the_customers_with_specific_age_and_name() {
        // Prepare
        int numberOfDummyCustomers = 9;
        List<Customer> customers = createDummyCustomers(numberOfDummyCustomers);

        // Exercise
        int age = 1;
        List<Customer> filteredCustomers = paginAndSortinCustomerRepository.findByAgeAndName(age, DUMMY_CUSTOMER_NAME);


        // Verify
        assertNotNull(filteredCustomers);
        assertEquals(1, filteredCustomers.size());
        Customer foundCustomer = filteredCustomers.get(0);
        assertEquals(DUMMY_CUSTOMER_NAME, foundCustomer.getName());
        assertEquals(age, foundCustomer.getAge());

    }



    private List<Customer> createDummyCustomers(int numberOfDummyCustomers) {
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < numberOfDummyCustomers; i++) {
            Customer customer = new Customer(new Long(i), DUMMY_CUSTOMER_NAME, i, new Address(new Long(i)));
            Customer savedCustomer = paginAndSortinCustomerRepository.save(customer);
            customers.add(customer);
        }

        return customers;
    }


}
