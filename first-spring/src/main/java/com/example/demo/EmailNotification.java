package com.example.demo;

public class EmailNotification implements NotificationService {
    @Override
    public void send(){
        System.out.println("Hello");
    }
}
