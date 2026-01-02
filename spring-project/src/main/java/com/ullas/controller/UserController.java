package com.ullas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ullas.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String name){
        userService.addUser(name);
        System.out.println("User Added : "+name);
    }
    public void listUsers(){
        List<String> users = userService.getAllUser();
        System.out.println("Users List "+users);
    }

    public void deleteUser(String name){
        userService.deleteUser(name);
        System.out.println("User Deleted : "+name);
    }
}
