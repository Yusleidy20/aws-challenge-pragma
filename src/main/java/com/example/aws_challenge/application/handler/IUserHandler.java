package com.example.aws_challenge.application.handler;

import com.example.aws_challenge.application.dto.request.UserRequestDto;
import com.example.aws_challenge.application.dto.response.UserResponseDto;

public interface IUserHandler {
    void saveUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long userId);
    UserResponseDto getUserByDni(Long dni);
}
