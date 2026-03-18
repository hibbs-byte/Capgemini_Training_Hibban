package com.capgi.bank.entity.dto;

import lombok.Data;

@Data
public class AccountDto {
    private String accountHolderName;
    private String holderEmail;
    private String accountSecureKey;
    private Long balance;
    private AccountType accountType;
}
