package com.jfdeveloper.springbootbank.repositories;

import com.jfdeveloper.springbootbank.entities.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
