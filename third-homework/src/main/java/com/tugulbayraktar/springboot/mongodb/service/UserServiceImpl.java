package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.converter.UserConverter;
import com.tugulbayraktar.springboot.mongodb.dto.UserDto;
import com.tugulbayraktar.springboot.mongodb.service.entityservice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityService userEntityService;

    @Override
    public List<UserDto> findAll() {
        return userEntityService.findAll();
    }

    @Override
    public UserDto findById(String id) {
        return userEntityService.findUserById(id);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return UserConverter.INSTANCE.convertUsersToUserDto(userEntityService.saveUser(userDto));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return UserConverter.INSTANCE.convertUsersToUserDto(userEntityService.updateUser(userDto));
    }

    @Override
    public Long deleteUserById(String id) {
        return userEntityService.deleteUserById(id);
    }
}
