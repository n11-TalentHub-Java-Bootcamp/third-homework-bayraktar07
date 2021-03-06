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
    public ResponseEntity<Object> findById(@PathVariable String id) {
        UserDto userDto = userService.findById(id);
        if(userDto != null) {
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.noContent().header("message", id + " Not found.").build();
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto){
        userDto = userService.saveUser(userDto);
        if(userDto != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(userDto.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body("Something went wrong..");
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {
        userDto = userService.updateUser(userDto);
        if(userDto != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(userDto.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body("Something went wrong..");
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteUserById(@RequestParam String id){
    Long deletedCount = userService.deleteUserById(id);
        if(deletedCount > 0) {
            return ResponseEntity.ok("ID: " + id + "\n " + deletedCount + " entry found and deleted.");
        }
        return ResponseEntity.notFound().header("message", "Entry " + id + " does not exist.").build();
    }
}
