package com.capgi.bank.service;

import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;

import java.util.List;

public interface AccountService {

    void createAccount(AccountDto accountDto);

    AccountResponseDto findById(Integer id);

    List<AccountResponseDto> findAll();

    AccountResponseDto findByIdException(Integer id);
}
