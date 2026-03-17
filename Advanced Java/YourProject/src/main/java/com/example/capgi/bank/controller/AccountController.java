package com.example.capgi.bank.controller;
import com.example.capgi.bank.constants.AccountConstant;
import com.example.capgi.bank.entity.dto.AccountDto;
import com.example.capgi.bank.entity.dto.AccountResponseDto;
import com.example.capgi.bank.entity.dto.ResponseDto;
import com.example.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstant.STATUS_200, AccountConstant.MESSAGE_200));
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<ResponseDto> getAccountById(@PathVariable Integer id) {
        AccountResponseDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200, AccountConstant.Message_get, accountDto));
    }

}



