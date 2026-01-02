package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private NotificationService notificationService;
    public UserService(){

    }
    @Autowired
    public UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void sendMessage(){
        notificationService.send();
    }
}
