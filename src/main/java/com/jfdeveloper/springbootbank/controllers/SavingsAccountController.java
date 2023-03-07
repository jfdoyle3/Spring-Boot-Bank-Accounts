package com.jfdeveloper.springbootbank.controllers;

import com.jfdeveloper.springbootbank.entities.Account;
import com.jfdeveloper.springbootbank.entities.Checking;
import com.jfdeveloper.springbootbank.entities.Savings;
import com.jfdeveloper.springbootbank.repositories.AccountRepository;
import com.jfdeveloper.springbootbank.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;


// Generate Account Numbers
// int accountNumberSavings=Math.abs((1 + randNumber.nextInt(2)) * (int)Math.pow(10,9) + randNumber.nextInt((int)Math.pow(10,9)));
// int accountNumberSavings=Math.abs(accountNumberSavings+((1 + randNumber.nextInt(2)) * (int)Math.pow(10,5) + randNumber.nextInt((int)Math.pow(10,5))));

@RestController
@CrossOrigin
@RequestMapping("/api/accounts/savings")
public class SavingsAccountController {
    private final long millis = System.currentTimeMillis();

    private final Random randNumber = new Random(millis);
    // private Date date=new Date(millis);


    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SavingsRepository repository;


    @GetMapping("/all")
    @ResponseBody
    public  List<Savings> getAccount() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Savings getOneAccount(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Savings> SavingsAccount(@RequestBody Savings account) {


        int accountNumberSavings = Math.abs((1 + randNumber.nextInt(2)) * (int) Math.pow(10, 9) + randNumber.nextInt((int) Math.pow(10, 9)));
        // TODO use this line below
        //
        //  int accountNumberSavings=Math.abs(accountNumberChecking+((1 + randNumber.nextInt(2)) * (int)Math.pow(10,5) + randNumber.nextInt((int)Math.pow(10,5))));

        Savings savings = new Savings(account.getName(),2000, accountNumberSavings);

        repository.save(savings);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    // TODO :  Deposit , Withdrawal methods.

    @PutMapping("/{id}")
    @ResponseBody
    public Savings updateAccount(@PathVariable Long id, @RequestBody Savings updates) {
        Savings account = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) account.setName(updates.getName());

        return repository.save(account);
    }


    // ex of Post need to create a Savings and Savings accounts
//    @PostMapping("/rate/{trackerId}/{cId}")
//    public ResponseEntity<CryptocurrencyInfo> rateById(@PathVariable Long trackerId,@PathVariable Long cId,
//                                                       @RequestBody SetRating setRating) {
//        Optional<CryptocurrencyInfo> currency = infoRepository.findById(cId);
//        Optional<Tracker> tracker = trackerRepository.findById(trackerId);
//
//        if (currency.isEmpty() || tracker.isEmpty())
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//
//        if (repository.existsByCurrency_id(cId)) {
//            Rating updateRating=repository.findByCurrencyId(cId);
//            updateRating.setRate(setRating.getRate());
//            repository.save(updateRating);
//            return new ResponseEntity<>(currency.get(), HttpStatus.CREATED);
//        }
//
//        Rating newRating = new Rating(tracker.get(), currency.get(), setRating.getRate());
//        repository.save(newRating);
//        return new ResponseEntity<>(currency.get(), HttpStatus.CREATED);
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyAccount(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
