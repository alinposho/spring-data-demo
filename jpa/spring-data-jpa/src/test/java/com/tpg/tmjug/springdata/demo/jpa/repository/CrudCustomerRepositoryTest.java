package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.ApplicationConfig;
import com.tpg.tmjug.springdata.demo.jpa.entities.Address;
import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class CrudCustomerRepositoryTest {

    @Autowired
    CrudCustomerRepository genericUserRepository;

    @Test
    public void should_save_and_retrieve_persisted_customer() {
        // Prepare
        Customer customer = new Customer("Doe", 21, new Address());

        // Exercise
        Customer savedCustomer = genericUserRepository.save(customer);
        Customer foundCustomer = genericUserRepository.findOne(savedCustomer.getId());

        // Verify
        assertNotNull(savedCustomer);
        assertEquals(savedCustomer, foundCustomer);
    }

}
