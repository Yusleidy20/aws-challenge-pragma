package com.example.aws_challenge.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long dni;
    private String userName;
    private String userEmail;
}
