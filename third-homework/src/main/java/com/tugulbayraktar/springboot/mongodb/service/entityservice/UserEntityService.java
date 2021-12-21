package com.tugulbayraktar.springboot.mongodb.service.entityservice;

import com.tugulbayraktar.springboot.mongodb.converter.ProductConverter;
import com.tugulbayraktar.springboot.mongodb.converter.UserConverter;
import com.tugulbayraktar.springboot.mongodb.dto.UserDto;
import com.tugulbayraktar.springboot.mongodb.entity.Users;
import com.tugulbayraktar.springboot.mongodb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    UsersRepository usersRepository;

    public List<UserDto> findAll() {
        return ProductConverter.INSTANCE.convertAllUserListToUserDtoList(usersRepository.findAll());
    }

    public UserDto findUserById(String id) {
        Optional<Users> userOptional = usersRepository.findById(id);
        return userOptional.map(UserConverter.INSTANCE::convertUsersToUserDto).orElse(null);
    }

    public Long deleteUserById (String id) {
        return usersRepository.deleteUserById(id);
    }

    public Users saveUser(UserDto userDto) {
        return usersRepository.insert(UserConverter.INSTANCE.convertUserDtoToUsers(userDto));
    }

    public Users updateUser(UserDto userDto){
        return usersRepository.save(UserConverter.INSTANCE.convertUserDtoToUsers(userDto));
    }
}
