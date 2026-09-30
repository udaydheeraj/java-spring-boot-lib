package com.tech.atm.exception;

public class AtmNotFoundException extends RuntimeException {
    AtmNotFoundException(String message)
    {
        super(message);
    }
}
