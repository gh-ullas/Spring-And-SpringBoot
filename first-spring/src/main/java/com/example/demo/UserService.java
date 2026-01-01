package com.example.demo;

public class UserService {

    private NotificationService notificationService;

    public UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void sendMessage(){
        notificationService.send();
    }
}
