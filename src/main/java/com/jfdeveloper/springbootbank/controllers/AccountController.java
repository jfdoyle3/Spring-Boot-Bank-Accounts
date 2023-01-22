package com.jfdeveloper.springbootbank.controllers;

import com.jfdeveloper.springbootbank.entities.Checking;
import com.jfdeveloper.springbootbank.repositories.CheckingRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@CrossOrigin
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private CheckingRepository repository;

    @GetMapping
    public @ResponseBody List<Checking> getAccount() {
        return repository.findAll();
    }


    // ex of Post need to create a Checking and Savings accounts
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
}
