package com.example.aws_challenge.infrastructure.exceptionhandler;

import com.example.aws_challenge.domain.exception.InvalidDniException;
import com.example.aws_challenge.domain.exception.InvalidUserEmailException;
import com.example.aws_challenge.domain.exception.InvalidUserNameException;
import com.example.aws_challenge.infrastructure.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(InvalidDniException.class)
    public ResponseEntity<String> handleInvalidDniException(InvalidDniException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidUserNameException.class)
    public ResponseEntity<String> handleInvalidUserNameException(InvalidUserNameException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidUserEmailException.class)
    public ResponseEntity<String> handleInvalidUserEmailException(InvalidUserEmailException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    //errores generics
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }

}
