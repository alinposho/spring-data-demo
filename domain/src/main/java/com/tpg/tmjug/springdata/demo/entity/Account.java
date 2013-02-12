package com.tpg.tmjug.springdata.demo.entity;

public class Account extends AbstractEntity {

    private long balance;

    public Account(long id, long balance) {
        super(id);
        this.balance = balance;
    }

    public Account(final long balance) {
        this.balance = balance;
    }

    protected Account() {
    }

    public long getBalance() {
        return balance;
    }

}
