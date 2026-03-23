package com.bank.capg.repository;

import com.bank.capg.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    // 🔥 mini statement
    List<Transaction> findByAccountId(Integer accountId);
}