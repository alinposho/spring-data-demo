package com.tpg.tmjug.springdata.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;

public class User extends AbstractEntity {

	private final String name;
	private final int age;
	private final List<Account> accounts;
	
	@PersistenceConstructor
	public User(String id, String name, int age, List<Account> accounts) {
		super(id);
		
		this.name = name;
		this.age = age;
		this.accounts = accounts;
	}
	
	public User(String name, int age, List<Account> accounts) {
		this(null, name, age, accounts);
	}
	
	public User(String name, int age) {
		this(null, name, age, new ArrayList<Account>());
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

}
