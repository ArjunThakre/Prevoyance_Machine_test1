package com.Employee.repository;

import com.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Employee findByUsername(String username);
    boolean existsByEmployeeId(String employeeId);
    boolean existsByEmail(String email);
    Optional<Employee> findByEmployeeCode(String employeeCode);
}
