package com.capgi.bank.service.impl;

import com.capgi.bank.config.CustomMapper;
import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.exception.AccountNotFoundException;
import com.capgi.bank.repository.AccountRepository;
import com.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountSeriveImpl implements AccountService {
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
    public AccountResponseDto findById(Integer id) {
//        Account referenceById = accountRepository.getReferenceById(id);
//        AccountResponseDto accountResponseDto = modelMapper.map(referenceById, AccountResponseDto.class);
        Optional<Account> account=accountRepository.findById(id);
        AccountResponseDto accountResponseDto = modelMapper.map(account.get(), AccountResponseDto.class);
        return accountResponseDto;
    }

    @Override
    public List<AccountResponseDto> findAll() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(account ->  modelMapper.map(accountList, AccountResponseDto.class))
                .toList();
    }

    @Override
    public AccountResponseDto findByIdException(Integer id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account not found"+id));
        AccountResponseDto accountResponseDto = modelMapper.map(account, AccountResponseDto.class);
        return accountResponseDto;
    }
}
