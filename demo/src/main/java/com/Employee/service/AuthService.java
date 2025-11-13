package com.Employee.service;

import com.Employee.entity.Employee;

public interface AuthService {
    public  String registerEmployee(Employee employee);

    public boolean loginEmployee(String username,String password);
}
