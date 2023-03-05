package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("transaction")
public class Transaction extends Account {


    private String transactionType;

    private int amount;

    public Transaction() {
    }

    public Transaction(String name, long accountNumber,int balance, String transactionType) {
        super(name,balance, accountNumber);
        this.transactionType = transactionType;

    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    @Override
    public void deposit(int amount) {

        balance += amount;

    }

    @Override
    public void withdraw(int amount) {

        balance -= amount;

    }

}

