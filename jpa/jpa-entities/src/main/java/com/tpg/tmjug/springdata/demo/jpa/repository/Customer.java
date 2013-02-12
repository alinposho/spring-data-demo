package com.tpg.tmjug.springdata.demo.jpa.repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractEntity {

    private String name;
    private int age;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Account> accounts = new ArrayList<>();

    protected Customer() {
    }

    public Customer(Long id, String name, int age, Address address, List<Account> accounts) {
        super(id);

        this.name = name;
        this.age = age;
        this.address = address;
        this.accounts = accounts;
    }

    public Customer(String name, int age, Address address, List<Account> accounts) {
        this(null, name, age, address, accounts);
    }

    public Customer(String name, int age, Address address) {
        this(null, name, age, address, null);
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
