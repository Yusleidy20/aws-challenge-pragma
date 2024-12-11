package com.example.aws_challenge.infrastructure.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super("User with the provided DNI already exists.");
    }
}
