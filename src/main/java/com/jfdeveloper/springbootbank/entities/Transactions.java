package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("transactions")
public class Transactions extends Account {


    private String transactionType;

    private int amount;

    public Transactions() {
    }

    public Transactions(String name, long accountNumber, String transactionType) {
        super(name, accountNumber);
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

