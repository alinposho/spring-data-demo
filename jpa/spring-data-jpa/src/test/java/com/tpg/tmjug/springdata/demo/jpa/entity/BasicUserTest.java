package com.tpg.tmjug.springdata.demo.jpa.entity;

import com.tpg.tmjug.springdata.demo.entity.User;
import com.tpg.tmjug.springdata.demo.jpa.config.ApplicationConfig;
import com.tpg.tmjug.springdata.demo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BasicUserTest {


	@Autowired
	private UserRepository genericUserRepository;
	
	@Before
	public void setup() {
		genericUserRepository.deleteAll();
	}
	
	@Test
	public void should_persist_new_user() {
        // Prepare
		final User user = new User("John", 21);

        // Exercise
		final User savedUser = genericUserRepository.save(user);
		final User foundUser = genericUserRepository.findOne(savedUser.getId());

        // Verify
		assertNotNull(savedUser);
		assertEquals(savedUser, foundUser);
	}
}
