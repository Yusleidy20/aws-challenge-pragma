package com.example.aws_challenge.infrastructure.out.jpa.repository;

import com.example.aws_challenge.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByDni(Long dni);
}
