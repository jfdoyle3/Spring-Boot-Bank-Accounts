package com.jfdeveloper.springbootbank.repositories;

import com.jfdeveloper.springbootbank.entities.Checking;
import com.jfdeveloper.springbootbank.entities.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
