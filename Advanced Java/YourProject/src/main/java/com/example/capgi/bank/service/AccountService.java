package com.example.capgi.bank.service;

import com.example.capgi.bank.entity.Account;
import com.example.capgi.bank.entity.dto.AccountDto;
import com.example.capgi.bank.entity.dto.AccountResponseDto;

public interface AccountService {
      void createAccount(AccountDto accountDto);

      AccountResponseDto getAccountById(Integer id);
}
