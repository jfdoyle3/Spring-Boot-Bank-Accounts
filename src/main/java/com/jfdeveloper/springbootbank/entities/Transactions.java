package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "transactions")
public class Transactions extends Account {


    private String transactionType;

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
    public void withdraw(int amount) {
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
