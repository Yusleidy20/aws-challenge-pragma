package com.example.aws_challenge.domain.api;

import com.example.aws_challenge.domain.model.UserModel;

import java.util.Optional;

public interface IUserServicePort {
    void saveUser(UserModel userModel);
    UserModel getUserById(Long userId);
    UserModel getUserByDni(Long dni);
}
