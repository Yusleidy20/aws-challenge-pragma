package com.example.aws_challenge.infrastructure.input.rest;


import com.example.aws_challenge.application.dto.request.UserRequestDto;
import com.example.aws_challenge.application.dto.response.UserResponseDto;
import com.example.aws_challenge.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @PostMapping("/users")
    public ResponseEntity<Void> saveUser(@RequestBody UserRequestDto userRequestDto){
        userHandler.saveUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/users/id/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable(name = "userId") Long userId){
        return ResponseEntity.ok(userHandler.getUserById(userId));
    }

    @GetMapping("/users/dni/{dni}")
    public ResponseEntity<UserResponseDto> getUserByDni(@PathVariable(name = "dni") Long dni){
        return ResponseEntity.ok(userHandler.getUserByDni(dni));
    }



}
