package com.tpg.tmjug.springdata.demo.mongodb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	private String firstName;
	private String lastName;
	
	private int age;
	
	@Indexed(unique = true)
	private EmailAddress emailAddress;
	
	@GeoSpatialIndexed
	private double[] location;
	
	private List<Account> accounts;
	
	public User(String firstName, String lastName, int age) {
		this(firstName, lastName, new double[] { 12.0d, 11.0d }, age, new ArrayList<Account>(), new EmailAddress(firstName + "@demo.com"));
	}

	@PersistenceConstructor
	public User(String firstName, String lastName, double[] location, int age, List<Account> accounts, EmailAddress emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.location = location;
		this.accounts = accounts;
		this.emailAddress = emailAddress;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}
	
	public double[] getLocation() {
		return location;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		if (age != other.age)
				return false;
		} else if (!lastName.equals(other.lastName)) {
			return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + firstName + ", password=" + lastName + "]";
	}
	
}
