package com.ullas;

import com.ullas.config.AppConfig;
import com.ullas.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserController  userController =  context.getBean(UserController.class);
        userController.createUser("Suhas");
        userController.createUser("Akash");
        userController.createUser("Ullas");
        userController.listUsers();
        userController.deleteUser("Ullas");
        userController.listUsers();
    }
}
