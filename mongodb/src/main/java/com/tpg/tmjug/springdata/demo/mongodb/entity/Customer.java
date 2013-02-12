package com.tpg.tmjug.springdata.demo.mongodb.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer extends AbstractEntity {

    private final String name;
    private final int age;
    
    private final EmailAddress emailAddress;

    private final Location location;
    
    private final List<Account> accounts ;
    
    @PersistenceConstructor
    public Customer(String id, String name, int age, EmailAddress emailAddress, Location location, List<Account> accounts) {
        super(id);

        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.location = location;
        this.accounts = accounts;
    }

    public Customer(String name, int age, Location location, List<Account> accounts) {
        this(null, name, age, new EmailAddress(name + "@tmjug.ro"), location, accounts);
    }

    public Customer(String name, int age) {
        this(name, age, new Location(new double[] { 12.0d, 11.0d }), new ArrayList<Account>());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Location getLocation() {
		return location;
	}
    
    public EmailAddress getEmailAddress() {
		return emailAddress;
	}
    
    public List<Account> getAccounts() {
        return accounts;
    }
	
}
