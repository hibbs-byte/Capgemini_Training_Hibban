package com.bank.capg.repository;

import com.bank.capg.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepo extends JpaRepository<Loan, String> {

    // 🔥 get loans by account
    List<Loan> findByAccountId(Integer accountId);

    // 🔥 get loans by status
    List<Loan> findByStatus(String status);
}