package com.tpg.tmjug.springdata.demo.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractEntity {

    private String name;
    private int age;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
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
