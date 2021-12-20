package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll ();

    UserDto findById(String id);

    UserDto insertUser (UserDto userDto);

    UserDto updateUser (UserDto userDto);

    Long deleteUserById (String id);
}
