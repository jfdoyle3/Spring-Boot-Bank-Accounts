package com.jfdeveloper.springbootbank.controllers;

import com.jfdeveloper.springbootbank.entities.Checking;
import com.jfdeveloper.springbootbank.repositories.CheckingRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class AccountController {

    @Autowired
    private CheckingRepository repository;

    @GetMapping
    public @ResponseBody List<Checking> getAccount() {
        return repository.findAll();
    }
}
