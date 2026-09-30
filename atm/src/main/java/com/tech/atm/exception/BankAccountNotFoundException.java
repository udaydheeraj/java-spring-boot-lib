package com.tech.atm.exception;

import org.springframework.stereotype.Component;

public class BankAccountNotFoundException extends ResourceNotFoundException{
    public BankAccountNotFoundException(String message)
    {
        super(message);
    }
}
