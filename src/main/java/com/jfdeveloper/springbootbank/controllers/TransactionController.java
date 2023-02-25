package com.jfdeveloper.springbootbank.controllers;

import com.jfdeveloper.springbootbank.entities.Savings;
import com.jfdeveloper.springbootbank.entities.Transactions;
import com.jfdeveloper.springbootbank.repositories.AccountRepository;
import com.jfdeveloper.springbootbank.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/transactions/")
public class TransactionController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionsRepository repository;

    @GetMapping("/all")
    @ResponseBody
    public List<Transactions> getAccount() {
        return repository.findAll();
    }
}
