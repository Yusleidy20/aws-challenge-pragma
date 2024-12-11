package com.example.aws_challenge.domain.exception;

public class InvalidUserEmailException extends RuntimeException {
    public InvalidUserEmailException(String message) {
        super(message);
    }
}
