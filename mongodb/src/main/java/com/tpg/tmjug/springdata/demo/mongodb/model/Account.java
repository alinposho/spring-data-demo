package com.tpg.tmjug.springdata.demo.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

	private long balance;

	public Account(final long balance) {
		this.balance = balance;
	}
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (balance != other.balance)
			return false;
		return true;
	}
	
}
