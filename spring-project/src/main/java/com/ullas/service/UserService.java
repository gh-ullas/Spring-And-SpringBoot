package com.ullas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ullas.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(String name){
        userRepository.save(name);
    }

    public List<String> getAllUser(){
        return userRepository.findAll();
    }
    public void deleteUser(String name){
        userRepository.delete(name);
    }
}
