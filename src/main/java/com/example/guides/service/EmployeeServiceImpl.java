package com.example.guides.service;

import com.example.guides.model.Employee;
import com.example.guides.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id).orElse(null);
    }
    public String deleteEmployee(long id){
        employeeRepository.deleteById(id);
        return "employee removed!!"+id;
    }

    public Employee updateEmployee(Employee employee)
    {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setFirstname(employee.getFirstname());
        existingEmployee.setLastname(employee.getLastname());
        existingEmployee.setEmailId(employee.getEmailId());
        return employeeRepository.save(existingEmployee);

    }

}
