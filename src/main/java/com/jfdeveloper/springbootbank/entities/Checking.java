package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "checking")
public class Checking extends Account{

    public Checking() {
    }

    public Checking(String name, long accountNumber) {
        super(name,accountNumber);
    }





    @Override
    public void deposit(int amount){}
    @Override
    public void withdraw(int amount){}
}
