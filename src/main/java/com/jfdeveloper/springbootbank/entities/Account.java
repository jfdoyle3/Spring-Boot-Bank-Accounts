package com.jfdeveloper.springbootbank.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;



@Entity(name="account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long accountId;
    protected String name;

//    @ManyToMany
//    @JoinTable(name = "AccountName", joinColumns = { @JoinColumn(name = "accountId", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "authorId", referencedColumnName = "id") })
//    private Set checking = new HashSet();
//
//    @ManyToMany
//    @JoinTable(name = "AccountName", joinColumns = { @JoinColumn(name = "accountId", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name ="authorId",referencedColumnName = "id") })
//    private Set savings = new HashSet();
    protected int balance;

    @Column
    @Temporal(TemporalType.DATE)
    protected Date openingDate;

    private long accountNumber;


    public Account() {
    }

    public Account(String name, long accountNumber) {
        this.name=name;
        this.accountNumber = accountNumber;
        balance=0;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public abstract void deposit(int amount);

    public abstract void withdraw(int amount);
}
