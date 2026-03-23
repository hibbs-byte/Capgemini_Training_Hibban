package com.bank.capg.dto;

public class CustomerDto {

    private String name;
    private String email;

    public CustomerDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}