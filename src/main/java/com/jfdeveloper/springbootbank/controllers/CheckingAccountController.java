package com.jfdeveloper.springbootbank.controllers;

import com.jfdeveloper.springbootbank.entities.Checking;
import com.jfdeveloper.springbootbank.entities.Savings;
import com.jfdeveloper.springbootbank.repositories.AccountRepository;
import com.jfdeveloper.springbootbank.repositories.CheckingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Random;


// Generate Account Numbers
// int accountNumberChecking=Math.abs((1 + randNumber.nextInt(2)) * (int)Math.pow(10,9) + randNumber.nextInt((int)Math.pow(10,9)));
// int accountNumberSavings=Math.abs(accountNumberChecking+((1 + randNumber.nextInt(2)) * (int)Math.pow(10,5) + randNumber.nextInt((int)Math.pow(10,5))));

@RestController
@CrossOrigin
@RequestMapping("/api/accounts/checking")
public class CheckingAccountController {
    private final long millis=System.currentTimeMillis();

    private final Random randNumber = new Random(millis);
    // private Date date=new Date(millis);


    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CheckingRepository repository;


    @GetMapping("/all")
    @ResponseBody
    public  List<Checking> getAllAccounts() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Checking getOneAccount(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Checking> checkingAccount(@RequestBody Checking account){


        int accountNumberChecking=Math.abs((1 + randNumber.nextInt(2)) * (int)Math.pow(10,9) + randNumber.nextInt((int)Math.pow(10,9)));
        //       int accountNumberSavings=Math.abs(accountNumberChecking+((1 + randNumber.nextInt(2)) * (int)Math.pow(10,5) + randNumber.nextInt((int)Math.pow(10,5))));

        Checking checking= new Checking(account.getName(),accountNumberChecking);

        repository.save(checking);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @ResponseBody
    public Checking updateAccount(@PathVariable Long id, @RequestBody Checking updates) {
       Checking account = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) account.setName(updates.getName());

        return repository.save(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyAccount(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
