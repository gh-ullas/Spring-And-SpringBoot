package com.ullas.db;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private List<String> users;

    public void init(){
        users = new ArrayList<>();
        System.out.println("Database Connected");
    }

    public void addUser(String user){
        users.add(user);
    }

    public List<String> getUsers(){
        return users;
    }

    public void deleteUser(String name){
        users.remove(name);
    }

    public void cleanup(){
        System.out.println("DB Disconnected");
    }
}
