package com.bank.capg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Loan {

    @Id
    private String loanId;

    private double amount;

    private String status; // APPROVED / REJECTED / PENDING

    @ManyToOne
    @JsonBackReference
    private Account account;
}