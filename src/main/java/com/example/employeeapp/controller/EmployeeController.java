package com.example.employeeapp.controller;

import com.example.employeeapp.model.Employee;
import com.example.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ── Web (HTML) endpoints ──────────────────────────────

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employees/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/employees/add")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // ── REST API endpoints (for Postman) ──────────────────

    @GetMapping("/api/employees")
    @ResponseBody
    public List<Employee> getAllEmployeesApi() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/api/employees/{id}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployeeByIdApi(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/employees")
    @ResponseBody
    public Employee createEmployeeApi(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/api/employees/{id}")
    @ResponseBody
    public ResponseEntity<Employee> updateEmployeeApi(
        @PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/api/employees/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteEmployeeApi(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}