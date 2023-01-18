package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public abstract class Account {

    @Id @GeneratedValue
    private Long accountId;
    private String name;

    private String accountNumber;
    protected double balance;

    public Account() {
    }

    public Account(String name, String accountNumber) {
        this.name=name;
        this.accountNumber = accountNumber;
        balance=0;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}
