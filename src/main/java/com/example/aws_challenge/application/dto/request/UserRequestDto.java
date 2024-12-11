package com.example.aws_challenge.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private Long dni;
    private String userName;
    private String userEmail;
}
