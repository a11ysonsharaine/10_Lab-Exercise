package com.appdev.eds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appdev.eds.repository.UserRepository;
import com.appdev.eds.entity.UserEntity;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
     UserRepository userRepository;

    // C - Create or insert user record in users
    public UserEntity insertUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    // R - Read all user record in users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // U - Update user record in users
    public UserEntity updateUser(Long userId, UserEntity newUserDetails) {
        UserEntity user = new UserEntity();
        try{
            //search the id number before update
            user = userRepository.findById(userId).get();

            //update details
            user.setName(newUserDetails.getName());
            user.setEmail(newUserDetails.getEmail());
            user.setPassword(newUserDetails.getPassword());
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("User with ID " + userId + " not found.");
        }finally {
            return userRepository.save(user);
        }
}

    // D - Delete user record in users
    public String deleteUser(Long userId) {
        String msg = "";

        if(userRepository.findById(userId) != null){
            userRepository.deleteById(userId);
            msg = "User with ID " + userId + " has been deleted.";
        } else {
            msg = "User with ID " + userId + " not found.";
        }
        return msg;
    }

}