package com.bank.capg.service;

import com.bank.capg.dto.AccountDto;
import com.bank.capg.entity.Account;

public interface AccountService {

    Account createAccount(Integer customerId, AccountDto dto);

    Account getAccount(Integer id);
}