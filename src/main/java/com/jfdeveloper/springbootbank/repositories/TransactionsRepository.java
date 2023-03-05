package com.jfdeveloper.springbootbank.repositories;

import com.jfdeveloper.springbootbank.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
}
