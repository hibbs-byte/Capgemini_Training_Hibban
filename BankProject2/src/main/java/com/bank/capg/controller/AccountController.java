package com.bank.capg.controller;

import com.bank.capg.dto.AccountDto;
import com.bank.capg.entity.Account;
import com.bank.capg.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/{customerId}")
    public Account createAccount(@PathVariable Integer customerId,
                                 @RequestBody AccountDto dto) {
        return accountService.createAccount(customerId, dto);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Integer id) {
        return accountService.getAccount(id);
    }
}