package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class SMSNotification implements NotificationService {
    @Override
    public void send(){
        System.out.println("Hello From SMS");
    }
}
