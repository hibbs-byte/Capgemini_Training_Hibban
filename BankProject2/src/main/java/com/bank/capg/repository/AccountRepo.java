package com.bank.capg.repository;

import com.bank.capg.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Integer> {


    List<Account> findByCustomerId(Integer customerId);
}