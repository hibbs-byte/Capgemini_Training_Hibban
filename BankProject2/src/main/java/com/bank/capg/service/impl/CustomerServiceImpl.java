package com.bank.capg.service.impl;

import com.bank.capg.dto.CustomerDto;
import com.bank.capg.entity.Customer;
import com.bank.capg.exception.ResourceNotFoundException;
import com.bank.capg.repository.CustomerRepository;
import com.bank.capg.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepo;

    @Override
    public Customer createCustomer(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }
}

