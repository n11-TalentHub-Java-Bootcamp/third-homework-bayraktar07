package com.tugulbayraktar.springboot.mongodb.controller;

import com.tugulbayraktar.springboot.mongodb.dto.UserDto;
import com.tugulbayraktar.springboot.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> findAll () {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public UserDto findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(UserDto userDto){
        userDto = userService.insertUser(userDto);
        if(userDto != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(userDto.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(UserDto userDto) {
        userDto = userService.updateUser(userDto);
        if(userDto != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(userDto.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
