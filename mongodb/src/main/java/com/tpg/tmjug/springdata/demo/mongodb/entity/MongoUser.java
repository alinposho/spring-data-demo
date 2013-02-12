package com.tpg.tmjug.springdata.demo.mongodb.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tpg.tmjug.springdata.demo.entity.User;

@Document
public class MongoUser extends User {

	@Indexed(unique = true)
	private EmailAddress emailAddress;
	
	@GeoSpatialIndexed
	private double[] location;
	
	public MongoUser(String name, int age) {
		this(null, name, age, new ArrayList<Account>(), new EmailAddress(name + "@demo.com"), new double[] { 12.0d, 11.0d });
	}

	@PersistenceConstructor
	public MongoUser(String id, String name, int age, List<Account> accounts, EmailAddress emailAddress, double[] location) {
		super(id, name, age, accounts);
		
		this.location = location;
		this.emailAddress = emailAddress;
	}
	
	public double[] getLocation() {
		return location;
	}
	
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "User [name=" + this.getName() + ", age=" + this.getAge() + "]";
	}
	
}
