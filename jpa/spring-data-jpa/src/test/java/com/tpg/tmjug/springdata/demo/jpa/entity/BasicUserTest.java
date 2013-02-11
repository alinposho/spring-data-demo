package com.tpg.tmjug.springdata.demo.jpa.entity;

import com.tpg.tmjug.springdata.demo.entity.Account;
import com.tpg.tmjug.springdata.demo.entity.User;
import com.tpg.tmjug.springdata.demo.repository.UserRepository;
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
@ContextConfiguration(locations = "classpath:spring/spring-data-jpa-application-context.xml")
public class BasicUserTest {

    @Autowired
    UserRepository genericUserRepository;

    @Test
    public void shouldPersistNewUser() {
        List<Account> accounts = Arrays.asList(new Account(78L));
        final User user = new User("John", "Doe", 21, accounts);

        final User savedUser = genericUserRepository.save(user);

        final User foundUser = genericUserRepository.findOne(savedUser.getId());

        assertNotNull(savedUser);
        assertEquals(savedUser, foundUser);
    }
}
