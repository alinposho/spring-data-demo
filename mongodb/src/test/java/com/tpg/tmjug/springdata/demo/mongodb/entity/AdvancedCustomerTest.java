package com.tpg.tmjug.springdata.demo.mongodb.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tpg.tmjug.springdata.demo.mongodb.config.ApplicationConfig;
import com.tpg.tmjug.springdata.demo.mongodb.repository.CustomerSearchRepository;
import com.tpg.tmjug.springdata.demo.mongodb.repository.SimpleCustomerRepository;
import com.tpg.tmjug.springdata.demo.mongodb.repository.StatisticsRepository;
import com.tpg.tmjug.springdata.demo.mongodb.repository.ValueObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AdvancedCustomerTest {

	@Autowired
	MongoTemplate template;
	
	@Autowired
	SimpleCustomerRepository customerRepository; 

	@Autowired
	StatisticsRepository statisticsRepository;

	@Autowired
	CustomerSearchRepository searchRepository;
	
	private Map<String, Long> accountBalances;

	@Before
	public void setup() {
		template.dropCollection(Customer.class);

		accountBalances = new HashMap<>();
		
		int magnitude = 1;

		for(int i = 1; i <= 10; i++) {
			long totalBalance = 0;
					
			final List<Account> accounts = new ArrayList<>();
			for(int j = 1; j <= 10; j++) {
				long balance = j * magnitude;
				totalBalance += balance;
				
				accounts.add(new Account(balance));
			}

			magnitude++;

			Customer customer = new Customer("Customer_" + i, 20 + magnitude, new Location(new double[] { 12.0d, 11.0d + (double)magnitude/1000 }), accounts);
			customer = customerRepository.save(customer);
			
			accountBalances.put(customer.getId(), totalBalance);
		}
	}

	@Test
	public void shouldComputeTotalBalanceForEachCustomer_usingMapReduce() {
		MapReduceResults<ValueObject> accountsTotal = statisticsRepository.getAccountsTotal();
		assertNotNull(accountsTotal);
		
		for(ValueObject obj: accountsTotal) {
			assertEquals(accountBalances.get(obj.getId()).longValue(), obj.getValue());
		}
	}
	
	@Test
	public void shouldGetOnlyCustomersOver25() {
		final List<Customer> customersOver25 = searchRepository.findByAgeGreaterThan(25);
		assertNotNull(customersOver25);
	}

	@Test
	public void shouldGetOnlyCustomersWithinRange() {
		final Circle centerPoint = new Circle(12.0d, 11.0d, 0.004);
		final List<Customer> customersCloseToCenter = searchRepository.findByLocation_PositionWithin(centerPoint);

		assertNotNull(customersCloseToCenter);
		assertEquals(3, customersCloseToCenter.size());
	}
	
	@Test
	public void shouldFindByAgeBetween21_28Paged() {
		/* should generate 6 result [22 - 27] => 3 pages of 2 elements each */
		final Page<Customer> resultPage = searchRepository.findByAgeBetween(21, 28, new PageRequest(1, 2));
		
		assertEquals(3, resultPage.getTotalPages());
		assertEquals(6, resultPage.getTotalElements());
		assertEquals(1, resultPage.getNumber());
		
		assertEquals("Customer_3", resultPage.getContent().get(0).getName());
		assertEquals("Customer_4", resultPage.getContent().get(1).getName());
	}
	
	@Test
	public void shouldFindByNameAlike_Customer_Sorted() {
		/* sort desc. by name */
		final Sort sort = new Sort(Direction.DESC, "name");
		
		/* should find: Customer_3, Customer_2, Customer_10, Customer_1 */
		final List<Customer> result = searchRepository.findByNameLike("Customer_[1-3]", sort);
		
		assertNotNull(result);
		assertEquals(4, result.size());
		assertEquals("Customer_3", result.get(0).getName());
		assertEquals("Customer_2", result.get(1).getName());
		assertEquals("Customer_10", result.get(2).getName());
		assertEquals("Customer_1", result.get(3).getName());
	}
}
