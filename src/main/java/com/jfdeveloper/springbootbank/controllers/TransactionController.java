package com.jfdeveloper.springbootbank.controllers;

import com.jfdeveloper.springbootbank.entities.Transaction;
import com.jfdeveloper.springbootbank.repositories.AccountRepository;
import com.jfdeveloper.springbootbank.repositories.CheckingRepository;
import com.jfdeveloper.springbootbank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private TransactionRepository repository;

    @GetMapping("/all")
    @ResponseBody
    public List<Transaction> getAccount() {
        return repository.findAll();
    }

    @PostMapping("/deposit")
    public void depositMoney(){
        Transaction transaction=new Transaction("Jim",1352196496,"Deposit");
        transaction.deposit(100);

        repository.save(transaction);
    }

}
