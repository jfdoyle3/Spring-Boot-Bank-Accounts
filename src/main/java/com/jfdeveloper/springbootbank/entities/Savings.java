package com.jfdeveloper.springbootbank.entities;

import com.jfdeveloper.springbootbank.entities.Account;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("savings")
public class Savings extends Account {

    public Savings() {
    }

    public Savings(String name, long accountNumber) {
        super(name, accountNumber);

    }



    @Override
    public void deposit(int amount) {}

    @Override
    public void withdraw(int amount) {}
}

