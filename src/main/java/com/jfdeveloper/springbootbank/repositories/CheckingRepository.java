package com.jfdeveloper.springbootbank.repositories;

import com.jfdeveloper.springbootbank.entities.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {

}
