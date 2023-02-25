package com.jfdeveloper.springbootbank.repositories;

import com.jfdeveloper.springbootbank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
