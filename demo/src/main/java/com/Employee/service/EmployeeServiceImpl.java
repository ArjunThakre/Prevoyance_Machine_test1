package com.Employee.service;

import com.Employee.entity.Employee;
import com.Employee.exception.ResourceNotFoundException;
import com.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

  @Autowired
  private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
       if(employeeRepository.existsByEmployeeId(employee.getEmployeeId())){
           throw new IllegalArgumentException("Employee Id Already Exist");
       }
       if (employeeRepository.existsByEmail(employee.getEmail())){
           throw new IllegalArgumentException("Email already Exist");
       }
       return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id:"+id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id:"+id));
        emp.setName(employee.getName());
        emp.setEmployeeId(employee.getEmployeeId());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(emp.getDepartment());
        emp.setSalary(employee.getSalary());
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
       Employee emp = employeeRepository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Employee not found with id:"+id));
       employeeRepository.delete(emp);
    }
}
