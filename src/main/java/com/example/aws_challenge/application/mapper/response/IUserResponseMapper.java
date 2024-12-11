package com.example.aws_challenge.application.mapper.response;

import com.example.aws_challenge.application.dto.response.UserResponseDto;
import com.example.aws_challenge.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    UserResponseDto toResponse(UserModel userModel);

}
