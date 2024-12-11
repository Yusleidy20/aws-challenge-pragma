package com.example.aws_challenge.domain.exception;

public class InvalidDniException extends RuntimeException {
    public InvalidDniException(String message) {
        super(message);
    }
}
