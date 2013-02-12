package com.tpg.tmjug.springdata.demo.mongodb.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.tpg.tmjug.springdata.demo.entity.Customer;
import com.tpg.tmjug.springdata.demo.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tpg.tmjug.springdata.demo.mongodb.config.MongoUserConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoUserConfig.class)
public class BasicUserTest {

	@Autowired
	MongoTemplate template;
	
	@Autowired
    CustomerRepository genericUserRepository;
	
	@Before
	public void setup() {
		template.dropCollection(Customer.class);
	}	
	
	@Test
	public void shouldPersistNewUser() {
		final Customer customer = new Customer("John", 21);
		final Customer savedCustomer = genericUserRepository.save(customer);
		
		final Customer foundCustomer = genericUserRepository.findOne(savedCustomer.getId());
		
		assertNotNull(savedCustomer);
		assertEquals(savedCustomer, foundCustomer);
	}
}
