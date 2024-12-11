package com.example.aws_challenge.infrastructure.out.jpa.mapper;

import com.example.aws_challenge.domain.model.UserModel;
import com.example.aws_challenge.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.swing.text.html.parser.Entity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    UserEntity toEntity(UserModel userModel);
    UserModel toUser(UserEntity userEntity);

}
