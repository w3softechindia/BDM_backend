package com.example.demo.Repoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
