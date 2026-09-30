package com.tech.atm.exception;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
