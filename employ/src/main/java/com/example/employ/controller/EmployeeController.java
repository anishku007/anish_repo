package com.example.employ.controller;

import com.example.employ.exception.ResourceNotFoundException;
import com.example.employ.model.Employee;
import com.example.employ.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Start - EmployeeController : employee");
        return repository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee employeeToUpdate = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setGender(employee.getGender());
        employeeToUpdate.setDateOfbirth(employee.getDateOfbirth());
        employeeToUpdate.setDepartment(employee.getDepartment());
        return repository.save(employeeToUpdate);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        LOGGER.info("Employee deleted success", id);

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }


}
