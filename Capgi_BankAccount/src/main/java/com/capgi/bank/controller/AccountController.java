package com.capgi.bank.controller;

import com.capgi.bank.constants.AccountConstant;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.entity.dto.ResponseDto;
import com.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody AccountDto accountDto){
        accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200));
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Integer id){
        AccountResponseDto accountResponseDto= accountService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.Message_get,accountResponseDto));
    }
    @GetMapping("/findAll")
    public ResponseEntity<ResponseDto> findAll(){
        List<AccountResponseDto> accountResponseDtoList=accountService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.Message_get,accountResponseDtoList));
    }

    @GetMapping("/findByIdException")
    public ResponseEntity<ResponseDto> findByIdException(@RequestParam Integer id){
        AccountResponseDto accountResponseDto= accountService.findByIdException(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.Message_get,accountResponseDto));
    }
}
