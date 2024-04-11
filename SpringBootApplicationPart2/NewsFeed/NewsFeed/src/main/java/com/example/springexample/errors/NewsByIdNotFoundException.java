package com.example.springexample.errors;

public class NewsByIdNotFoundException extends RuntimeException {
    public NewsByIdNotFoundException(String message) {
        super(message);
    }
}
