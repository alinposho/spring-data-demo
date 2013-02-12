package com.tpg.tmjug.springdata.demo.mongodb.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tpg.tmjug.springdata.demo.mongodb.config.ApplicationConfig;
import com.tpg.tmjug.springdata.demo.mongodb.repository.SimpleCustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SimpleCustomerTest {

	@Autowired
	MongoTemplate template;
	
	@Autowired
    SimpleCustomerRepository customerRepository;
	
	@Before
	public void setupTest() {
		template.dropCollection(Customer.class);
		
		int magnitude = 1;
		for(int i = 1; i <= 10; i++) {
			final Customer customer = new Customer("Customer_" + i, 20 + magnitude++);
			customerRepository.save(customer);
		}
	}	
	
	@Test
	public void shouldPersistNewCustomers() {
		final Customer customer = new Customer("John", 21);
		final Customer savedCustomer = customerRepository.save(customer);
		
		final Customer foundCustomer = customerRepository.findOne(savedCustomer.getId());
		
		assertNotNull(savedCustomer);
		assertEquals(savedCustomer, foundCustomer);
	}
	
	@Test
	public void shouldCountTenCustomers() {
		assertEquals(10, customerRepository.count());
	}
	
	@Test
	public void shouldGetCustomerByName() {
		final Customer customer = customerRepository.getByName("Customer_1");
		
		assertNotNull(customer);
		assertEquals("Customer_1", customer.getName());
	}
	
	@Test 
	public void shouldDeleteCustomer() {
		final Customer customer = customerRepository.getByName("Customer_1");
		customerRepository.delete(customer);
		
		assertFalse(customerRepository.exists(customer.getId()));
		assertEquals(9, customerRepository.count());
	}
}
