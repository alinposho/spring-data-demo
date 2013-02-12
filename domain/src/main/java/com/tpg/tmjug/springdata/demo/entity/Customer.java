package com.tpg.tmjug.springdata.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Customer extends AbstractEntity {

    private String name;
    private int age;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    protected Customer() {
    }

    public Customer(Long id, String name, int age, List<Account> accounts) {
        super(id);

        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public Customer(String name, int age, List<Account> accounts) {
        this(null, name, age, accounts);
    }

    public Customer(String name, int age) {
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
