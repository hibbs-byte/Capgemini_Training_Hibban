package com.bank.capg.service.impl;

import com.bank.capg.dto.AccountDto;
import com.bank.capg.entity.Account;
import com.bank.capg.entity.Customer;
import com.bank.capg.exception.ResourceNotFoundException;
import com.bank.capg.repository.AccountRepo;
import com.bank.capg.repository.CustomerRepository;
import com.bank.capg.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final CustomerRepository customerRepo;

    @Override
    public Account createAccount(Integer customerId, AccountDto dto) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Account account = new Account();
        account.setType(dto.getType());
        account.setBalance(dto.getBalance());
        account.setCustomer(customer);

        return accountRepo.save(account);
    }

    @Override
    public Account getAccount(Integer id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }
}