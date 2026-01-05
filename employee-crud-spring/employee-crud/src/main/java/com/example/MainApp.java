package com.example;

import com.example.controller.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        EmployeeController employeeController = context.getBean(EmployeeController.class);

        employeeController.start();
    }

}
