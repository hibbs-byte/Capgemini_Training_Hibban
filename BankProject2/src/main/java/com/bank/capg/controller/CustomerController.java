package com.bank.capg.controller;

import com.bank.capg.dto.CustomerDto;
import com.bank.capg.entity.Customer;
import com.bank.capg.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public Customer create(@RequestBody CustomerDto dto) {
        return customerService.createCustomer(dto);
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }
}

