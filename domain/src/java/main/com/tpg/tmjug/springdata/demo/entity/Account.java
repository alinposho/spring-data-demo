package com.tpg.tmjug.springdata.demo.entity;

public class Account {

	private final long balance;

	public Account(final long balance) {
		this.balance = balance;
	}
	
	public long getBalance() {
		return balance;
	}
	
}
