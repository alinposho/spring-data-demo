package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.AbstractIntegrationTest;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
@Ignore
public class CrudCustomerRepositoryXmlConfigTest extends AbstractIntegrationTest {

    @Autowired
    CrudCustomerRepository crudCustomerRepository;


    @After
    public void cleanUp() {
        crudCustomerRepository.deleteAll();
    }

    @Test
    public void should_save_and_retrieve_persisted_customer() {
        // Prepare
        Customer customer = new Customer("Doe", 21, new Address());

        // Exercise
        Customer savedCustomer = crudCustomerRepository.save(customer);
        Customer foundCustomer = crudCustomerRepository.findOne(savedCustomer.getId());

        // Verify
        assertNotNull(savedCustomer);
        assertEquals(savedCustomer, foundCustomer);
    }


    @Test
    public void should_find_all_customers() {
        // Exercise
        Iterable<Customer> allCustomers = crudCustomerRepository.findAll();


        // Verify
        assertNotNull(allCustomers);
        int expectedNumberOfCustomers = 3;
        assertTrue("More than one record in the DB", allCustomers.iterator().hasNext());
    }

}
