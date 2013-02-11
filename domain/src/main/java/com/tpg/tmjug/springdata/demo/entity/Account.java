package com.tpg.tmjug.springdata.demo.entity;

import javax.persistence.Entity;

@Entity
public class Account extends AbstractEntity {

	private final long balance;

	public Account(final long balance) {
		this.balance = balance;
	}
	
	public long getBalance() {
		return balance;
	}
	
}
