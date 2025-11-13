package com.Employee.service;

import com.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getEmployee();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    //Employee createEmployee(Employee employee);
   // Employee updateEmployee(Long id, Employee employee);
   // void deleteEmployee(Long id);
   // List<Employee> getAllEmployees();
  //  Employee getEmployeeById(Long id);
}
