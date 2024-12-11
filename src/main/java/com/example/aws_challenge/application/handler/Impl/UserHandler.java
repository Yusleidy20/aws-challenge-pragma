package com.example.aws_challenge.application.handler.Impl;

import com.example.aws_challenge.application.dto.request.UserRequestDto;
import com.example.aws_challenge.application.dto.response.UserResponseDto;
import com.example.aws_challenge.application.handler.IUserHandler;
import com.example.aws_challenge.application.mapper.request.IUserRequestMapper;
import com.example.aws_challenge.application.mapper.response.IUserResponseMapper;
import com.example.aws_challenge.domain.api.IUserServicePort;
import com.example.aws_challenge.domain.model.UserModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(userModel);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        UserModel userModel = userServicePort.getUserById(userId);
        return userResponseMapper.toResponse(userModel);
    }

    @Override
    public UserResponseDto getUserByDni(Long dni) {
        UserModel userModel = userServicePort.getUserByDni(dni);
        return userResponseMapper.toResponse(userModel);
    }


}
