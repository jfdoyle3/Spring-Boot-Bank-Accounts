package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Account {

    @Id @GeneratedValue
    private Long accountId;
    private String name;

    private int accountNumber;
    protected double balance;

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
