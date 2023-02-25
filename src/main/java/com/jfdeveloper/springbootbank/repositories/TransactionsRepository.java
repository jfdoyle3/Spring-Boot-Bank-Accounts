package com.jfdeveloper.springbootbank.repositories;

import com.jfdeveloper.springbootbank.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
