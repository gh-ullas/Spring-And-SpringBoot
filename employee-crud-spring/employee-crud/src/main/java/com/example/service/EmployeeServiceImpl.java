package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addEmployee(Employee employee){
        if(employee == null){
            throw new IllegalArgumentException("Invalid Employee (null)");
        }
        if(employee.getName()==null || employee.getName().isBlank()){
            throw new IllegalArgumentException("Invalid Employee Name");
        }
        if(employee.getSalary()<=0){
            throw new IllegalArgumentException("Salary Cannot Be Zero Or Less");
        }
        employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @Override
    public  Employee getEmployeeById(int id){
        return employeeRepository.findById(id);
    }
    @Override
    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }
}
