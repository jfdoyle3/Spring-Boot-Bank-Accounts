package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =“id”, updatable = false, nullable = false)
    protected Long accountId;
    protected String name;

    @ManyToMany
    @JoinTable(name = “AccountName”, joinColumns = { @JoinColumn(name = “accountId”, referencedColumnName = “id”) }, inverseJoinColumns = { @JoinColumn(name = “authorId”, referencedColumnName = “id”) })
    private Set checking = new HashSet();

    @ManyToMany
    @JoinTable(name = “AccountName”, joinColumns = { @JoinColumn(name = “accountId”, referencedColumnName = “id”) }, inverseJoinColumns = { @JoinColumn(name = “authorId”, referencedColumnName = “id”) })
    private Set savings = new HashSet();
    protected double balance;

    @Column
    @Temporal(TemporalType.DATE)
    protected Date openingDate;



    public Account() {
    }

    public Account(String name, int accountNumber) {
        this.name=name;
        this.accountNumber = accountNumber;
        balance=0;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}
