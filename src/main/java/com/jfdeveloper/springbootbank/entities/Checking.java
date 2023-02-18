package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.Entity;

@Entity
public class Checking extends Account{


    public Checking(String name, int accountNumber) {
        super(name,accountNumber);
    }

    @Override
    public void deposit(double amount) {
        if(amount>0){
            balance+=amount;
            System.out.printf("Amount %.2f deposited%n",amount);
            System.out.printf("Current Balance is: %.2f%n",balance);
        }
        else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount>0){
            if((amount)<=balance){
                System.out.printf("Amount %.2f withdrawn from Account%n",amount);
                balance-=amount;
                System.out.printf("Current Balance is: %.2f%n",balance);
            }
        }
        else {
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}
