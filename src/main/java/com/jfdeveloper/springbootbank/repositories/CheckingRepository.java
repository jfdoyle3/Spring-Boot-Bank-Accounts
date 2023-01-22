package com.jfdeveloper.springbootbank.repositories;

import com.jfdeveloper.springbootbank.entities.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
