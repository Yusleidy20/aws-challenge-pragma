package com.example.aws_challenge.domain.usecase;

import com.example.aws_challenge.domain.api.IUserServicePort;
import com.example.aws_challenge.domain.exception.InvalidDniException;
import com.example.aws_challenge.domain.exception.InvalidUserEmailException;
import com.example.aws_challenge.domain.exception.InvalidUserNameException;
import com.example.aws_challenge.domain.model.UserModel;
import com.example.aws_challenge.domain.spi.IUserPersistencePort;


public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public void saveUser(UserModel userModel) {
        validateUser(userModel);
        userPersistencePort.saveUser(userModel);
    }

    @Override
    public UserModel getUserById(Long userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public UserModel getUserByDni(Long dni) {
        return userPersistencePort.getUserByDni(dni);
    }

    private void validateUser(UserModel userModel) {
        if (userModel.getDni() == null) {
            throw new InvalidDniException("DNI is required and cannot be null");
        }
        if (userModel.getDni() <= 0) {
            throw new InvalidDniException("DNI must be a positive number");
        }
        if (userModel.getUserName() == null || userModel.getUserName().isEmpty()) {
            throw new InvalidUserNameException("User name is required and cannot be empty");
        }
        if (userModel.getUserEmail() == null || userModel.getUserEmail().isEmpty()) {
            throw new InvalidUserEmailException("User email is required and cannot be empty");
        }
        if (!userModel.getUserEmail().contains("@")) {
            throw new InvalidUserEmailException("User email format is invalid");
        }
    }


}
