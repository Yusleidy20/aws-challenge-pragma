package com.example.aws_challenge.infrastructure.out.jpa.adapter;


import com.example.aws_challenge.domain.model.UserModel;
import com.example.aws_challenge.domain.spi.IUserPersistencePort;
import com.example.aws_challenge.infrastructure.exception.UserAlreadyExistsException;
import com.example.aws_challenge.infrastructure.exception.UserNotFoundException;
import com.example.aws_challenge.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.example.aws_challenge.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(UserModel userModel) {
        if(userRepository.findByDni(userModel.getDni()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        userRepository.save(userEntityMapper.toEntity(userModel));
    }

    @Override
    public UserModel getUserById(Long userId) {
        return userEntityMapper.toUser(userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new));
    }

    @Override
    public UserModel getUserByDni(Long dni) {
        return userEntityMapper.toUser(userRepository.findByDni(dni)
                .orElseThrow(UserNotFoundException::new));
    }
}
