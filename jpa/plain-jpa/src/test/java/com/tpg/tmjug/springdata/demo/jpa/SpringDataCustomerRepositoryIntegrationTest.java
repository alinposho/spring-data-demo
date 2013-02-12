/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tpg.tmjug.springdata.demo.jpa;

import com.tpg.tmjug.springdata.demo.jpa.entity.Account;
import com.tpg.tmjug.springdata.demo.jpa.entity.Address;
import com.tpg.tmjug.springdata.demo.jpa.entity.Customer;
import com.tpg.tmjug.springdata.demo.jpa.repository.CustomerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
public class SpringDataCustomerRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
    CustomerRepository repository;

	@Test
	public void should_inserts_new_customer_correctly() {

        // Prepare
        List<Account> accounts = Arrays.asList(new Account(78L));
        Address address = new Address( "27 Broadway", "New York", "United States");
        Customer customer = new Customer("Doe@3pg.com", 21, address, accounts);

        // Exercise
		customer = repository.save(customer);

        // Verify
		assertThat(customer.getId(), is(notNullValue()));
	}

	@Test
	public void should_find_customer_by_address_correctly() {

        // Prepare
        Address address = new Address( "27 Broadway", "New York", "United States");

        Customer customer = new Customer("Doe@3pg.com", 21, address);
        customer = repository.save(customer);

        // Exercise
        Customer foundCustomer = repository.findByAddress(address);

        // Verify
		assertThat(foundCustomer, is(customer));
	}
}
