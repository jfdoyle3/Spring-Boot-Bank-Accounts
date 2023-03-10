package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("checking")
public class Checking extends Account{

    public Checking() {
    }

    public Checking(String name, int balance, long accountNumber) {
        super(name,balance,accountNumber);
    }





    @Override
    public void deposit(int amount){}
    @Override
    public void withdraw(int amount){}
}
