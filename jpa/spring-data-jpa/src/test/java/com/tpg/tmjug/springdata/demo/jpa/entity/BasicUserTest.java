package com.tpg.tmjug.springdata.demo.jpa.entity;

import com.tpg.tmjug.springdata.demo.entity.Account;
import com.tpg.tmjug.springdata.demo.entity.Customer;
import com.tpg.tmjug.springdata.demo.jpa.config.ApplicationConfig;
import com.tpg.tmjug.springdata.demo.repository.CustomerRepository;
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
@ContextConfiguration(classes = ApplicationConfig.class)
public class BasicUserTest {

    @Autowired
    CustomerRepository genericUserRepository;

    @Test
    public void shouldPersistNewUser() {
        List<Account> accounts = Arrays.asList(new Account(78L));
        final Customer customer = new Customer("John", "Doe", 21, accounts);

        final Customer savedCustomer = genericUserRepository.save(customer);

        final Customer foundCustomer = genericUserRepository.findOne(savedCustomer.getId());

        assertNotNull(savedCustomer);
        assertEquals(savedCustomer, foundCustomer);
    }
}
