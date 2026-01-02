package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationService {
    @Override
    public void send(){
        System.out.println("Hello From Email");
    }
}
