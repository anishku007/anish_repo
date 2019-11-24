package com.example.employ;

import com.example.employ.model.Employee;
import com.example.employ.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployApplicationTests {

    @InjectMocks
    Employee employee;

    @Mock
    EmployeeRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployeesTest() {
        List<Employee> list = new ArrayList<>();
        Employee empOne = new Employee((long) 1, "Anish", "Kumar", "male", "16/07/1992", "Developer");
        Employee empTwo = new Employee((long) 1, "Bikash", "Kumar", "male", "16/07/1992", "Developer");

        list.add(empOne);
        list.add(empTwo);
        when(repository.findAll()).thenReturn(list);

        //test
        List<Employee> empList = repository.findAll();

        assertEquals(2, empList.size());
    }

    @Test
    public void getEmployeeByIdTest() {
        when(repository.getOne((long) 1)).thenReturn(new Employee((long) 1, "Anish", "Kumar", "male", "16/07/1992", "Developer"));

        Employee emp = repository.getOne((long) 1);

        assertEquals("Anish", emp.getFirstName());
        assertEquals("Kumar", emp.getLastName());
    }

    @Test
    public void createEmployeeTest() {
        Employee emp = new Employee((long) 1, "Anish", "Kumar", "male", "16/07/1992", "Developer");

        repository.save(emp);

        //verify(repository, times(1)).addEmployee(emp);
    }
}

