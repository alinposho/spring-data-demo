package com.tpg.tmjug.springdata.demo;

import com.tpg.tmjug.springdata.demo.entity.Account;
import com.tpg.tmjug.springdata.demo.entity.Customer;
import com.tpg.tmjug.springdata.demo.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:simple-repository-context.xml")
public class BasicCustomerTest {

    @Autowired
    CustomerRepository genericCustomerRepository;

    @Test
    public void should_persist_and_find_new_customer() {
        // Prepare
        List<Account> accounts = Arrays.asList(new Account(13L, 78L));
        Customer customer = new Customer(123L, "Doe", 21, accounts);

        // Exercise
        Customer savedCustomer = genericCustomerRepository.save(customer);
        Customer foundCustomer = genericCustomerRepository.findOne(savedCustomer.getId());

        // Verify
        assertNotNull(savedCustomer);
        assertEquals(savedCustomer, foundCustomer);
    }

    @Test
    public void should_delete_customer() {
        // Prepare
        List<Account> accounts = Arrays.asList(new Account(13L, 78L));
        Customer customer = new Customer(123L, "Doe", 21, accounts);
        Customer savedCustomer = genericCustomerRepository.save(customer);

        // Exercise
        genericCustomerRepository.delete(customer);

        // Verify
        assertNull(genericCustomerRepository.findOne(customer.getId()));
    }
}
