package com.example.aws_challenge.domain.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    private Long userId;
    private Long dni;
    private String userName;
    private String userEmail;
}
