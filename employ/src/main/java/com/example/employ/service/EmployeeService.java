package com.example.employ.service;

import com.example.employ.exception.ResourceNotFoundException;
import com.example.employ.model.Employee;
import com.example.employ.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  /*  @Autowired
    private EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long id,Employee employee){
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setGender(employee.getGender());
        employeeToUpdate.setDateOfbirth(employee.getDateOfbirth());
        employeeToUpdate.setDepartment(employee.getDepartment());
        return employeeToUpdate;
    }
    public Employee getEmployee(Long id)
    {
        return  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }
    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }
    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteById(id);
    }*/
}
