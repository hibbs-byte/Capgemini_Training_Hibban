package com.bank.capg.service;

import com.bank.capg.dto.CustomerDto;
import com.bank.capg.entity.Customer;

public interface CustomerService {
    Customer createCustomer(CustomerDto dto);
    Customer getCustomerById(Integer id);
}
