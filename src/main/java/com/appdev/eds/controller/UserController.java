package com.appdev.eds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.eds.entity.UserEntity;
import com.appdev.eds.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
     UserService userService;

     //print Hello
    @GetMapping("/print")
    public String printHello() {
        return "Hello, John Doe!";
    }

    @PostMapping("/insertUser")
    public UserEntity insertUser(@RequestBody UserEntity userEntity) {
        return userService.insertUser(userEntity);
    }
    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }   

    //Update a user record
    @PutMapping("/updateUser")
    public UserEntity updateUser(@RequestParam Long userId, @RequestBody UserEntity newUserDetails) {
        return userService.updateUser(userId, newUserDetails);
     }

    // Delete a user record
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId){
        return userService.deleteUser(userId);
     }
}