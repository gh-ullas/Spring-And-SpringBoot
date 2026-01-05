package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public void start(){
        while(true){
            showMenu();
            int choice = readInt();

            switch(choice){
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> viewEmployeeById();
                case 4 -> deleteEmployee();
                case 5 ->{
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Invalid Choice Enter Again");
            }
        }
    }

    public void showMenu(){
        System.out.println("\n====== Employee Management System ======");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. View Employee By ID");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private void addEmployee(){
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            System.out.print("Enter salary: ");
            double salary = readDouble();

            Employee employee = new Employee();
            employee.setName(name);
            employee.setDepartment(department);
            employee.setSalary(salary);

            employeeService.addEmployee(employee);
            System.out.println("Employee added successfully.");
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAllEmployees(){
        List<Employee> employees  = employeeService.getAllEmployees();
        if(employees.isEmpty()){
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n--- Employee List ---");
        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName() + " | "
                    + e.getDepartment() + " | " + e.getSalary());
        }
    }
    private void viewEmployeeById() {
        try {
            System.out.print("Enter employee ID: ");
            int id = readInt();

            Employee employee = employeeService.getEmployeeById(id);
            System.out.println(
                    employee.getId() + " | " +
                            employee.getName() + " | " +
                            employee.getDepartment() + " | " +
                            employee.getSalary()
            );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteEmployee() {
        try {
            System.out.print("Enter employee ID to delete: ");
            int id = readInt();

            employeeService.deleteEmployeeById(id);
            System.out.println("Employee deleted successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    private double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
}
