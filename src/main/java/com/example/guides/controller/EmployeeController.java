package com.example.guides.controller;

import com.example.guides.model.Employee;
import com.example.guides.repository.EmployeeRepository;
import com.example.guides.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
//@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    // build create employee REST API
    @PostMapping("/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveEmployees(employees);
    }

    // build get employee by id REST API
    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable long id)
    {
        return employeeService.getEmployeeById(id);
    }

    // build update employee REST API
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // build delete employee REST API
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);
    }



}