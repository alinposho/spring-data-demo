package com.tpg.tmjug.springdata.demo.mongodb.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
    
	private long balance;

	@PersistenceConstructor
    public Account(final long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }
    
}
