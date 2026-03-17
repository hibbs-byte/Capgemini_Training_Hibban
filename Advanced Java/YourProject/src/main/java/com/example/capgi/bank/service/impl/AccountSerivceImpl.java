package com.example.capgi.bank.service.impl;

import com.example.capgi.bank.config.CustomMapper;
import com.example.capgi.bank.entity.Account;
import com.example.capgi.bank.entity.dto.AccountDto;
import com.example.capgi.bank.entity.dto.AccountResponseDto;
import com.example.capgi.bank.repository.AccountRepository;
import com.example.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountSerivceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createAccount(AccountDto accountDto) {
//        Account account = new Account();
//        account.setAccountHolderName(accountDto.getAccountHolderName());
//        account.setAccountType(accountDto.getAccountType());
//        account.setAccountSecureKey(accountDto.getAccountSecureKey());
//        account.setHolderEmail(accountDto.getHolderEmail());
//        account.setBalance(accountDto.getBalance());
        Account account = CustomMapper.mapAccountDtoToAccount(accountDto, new Account());
        accountRepository.save(account);
    }
    @Override
    public AccountResponseDto getAccountById(Integer id) {
        Account account = accountRepository.getReferenceById(id);
        AccountResponseDto accountDto=modelMapper.map(account,AccountResponseDto.class);
        return accountDto;
    }

    public List<AccountResponseDto> findAll()
    {
        List<Account> accountList = accountRepository.findAll();
        List<AccountResponseDto> accountResponseDtoList = accountList.stream().map(account -> modelMapper.map(account, AccountResponseDto.class))
                .toList();
        return accountResponseDtoList;

    }



}
