package com.example.aws_challenge.infrastructure.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found.");
    }
}
