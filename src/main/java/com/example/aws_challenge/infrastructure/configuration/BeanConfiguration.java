package com.example.aws_challenge.infrastructure.configuration;


import com.example.aws_challenge.domain.api.IUserServicePort;
import com.example.aws_challenge.domain.spi.IUserPersistencePort;
import com.example.aws_challenge.domain.usecase.UserUseCase;
import com.example.aws_challenge.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.example.aws_challenge.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.example.aws_challenge.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;


    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository,userEntityMapper);
    }
    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }
}
