package com.example.employeeapp.service;

import com.example.employeeapp.model.Employee;
import com.example.employeeapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ ONE
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee updatedEmp) {
        Employee emp = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setFirstName(updatedEmp.getFirstName());
        emp.setLastName(updatedEmp.getLastName());
        emp.setEmail(updatedEmp.getEmail());
        emp.setDepartment(updatedEmp.getDepartment());
        emp.setSalary(updatedEmp.getSalary());
        return employeeRepository.save(emp);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}