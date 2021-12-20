package com.tugulbayraktar.springboot.mongodb.converter;

import com.tugulbayraktar.springboot.mongodb.dto.UserDto;
import com.tugulbayraktar.springboot.mongodb.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);


    Users convertUserDtoToUser(UserDto userDto);

    UserDto convertUserToUserDto(Users users);
}
