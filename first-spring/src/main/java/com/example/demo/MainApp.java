package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingService gs = context.getBean(GreetingService.class);
        gs.sayHello();

        UserService us = context.getBean(UserService.class);
        us.sendMessage();

    }
}
