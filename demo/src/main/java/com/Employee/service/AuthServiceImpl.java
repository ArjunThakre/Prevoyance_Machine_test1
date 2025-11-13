package com.Employee.service;

import com.Employee.entity.Employee;
import com.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public String registerEmployee(Employee employee) {
        if (repository.findByUsername(employee.getUsername())!=null){
            return "Username is already Exist";
        }
        repository.save(employee);
        return "Employee Register Successfully";
    }

    @Override
    public boolean loginEmployee(String username, String password) {
        Employee employee=repository.findByUsername(username);
        return employee!=null && employee.getPassword().equals(password);
    }

}
