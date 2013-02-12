package com.tpg.tmjug.springdata.demo.jpa.entity;

import com.tpg.tmjug.springdata.demo.jpa.ApplicationConfig;
import com.tpg.tmjug.springdata.demo.jpa.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
public class BasicCustomerXmlConfixTest {

    @Autowired
    CustomerRepository genericUserRepository;

    @Test
    public void shouldPersistNewUser() {
        // Prepare
        List<Account> accounts = Arrays.asList(new Account(78L));
        Customer customer = new Customer("Doe", 21, accounts);

        // Exercise
        Customer savedCustomer = genericUserRepository.save(customer);
        Customer foundCustomer = genericUserRepository.findOne(savedCustomer.getId());

        // Verify
        assertNotNull(savedCustomer);
        assertEquals(savedCustomer, foundCustomer);
    }
}
