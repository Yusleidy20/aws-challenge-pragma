package com.example.aws_challenge.domain.spi;

import com.example.aws_challenge.domain.model.UserModel;

public interface IUserPersistencePort {
    void saveUser(UserModel userModel);
    UserModel getUserById(Long userId);
    UserModel getUserByDni(Long dni);
}
