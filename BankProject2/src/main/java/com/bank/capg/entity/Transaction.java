package com.bank.capg.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer txnId;
    private String type; // DEPOSIT, WITHDRAW, TRANSFER
    private double amount;
    private LocalDateTime date;
    @ManyToOne
    private Account account;
}