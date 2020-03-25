package com.epam.employee.service;

import com.epam.employee.models.EmployeeModel;
import com.epam.employee.repo.entities.Employee;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
public class EmployeeServiceImpTests {


    private ModelMapper mapper = new ModelMapper();



    @Test
    public void shouldInstantiateMapper() {
        assertThat(mapper, is(notNullValue()));
    }

    @Test
    public void convertEmployeeEntityToEmployeeModel() {
        Employee employee = new Employee();
        employee.setFirstName("ibrahim");
        employee.setLastName("fouad");
        employee.setEmail("abc@gmail.com");
        employee.setPassword("123456");
        EmployeeModel employeeModel = mapper.map(employee, EmployeeModel.class);
        assertEquals(employee.getFirstName(), employeeModel.getFirstName());
        assertEquals(employee.getLastName(), employeeModel.getLastName());
        assertEquals(employee.getEmail(), employeeModel.getEmail());
    }

    @Test
    public void convertEmployeeModelToEmployeeEntity() {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setFirstName("ibrahim");
        employeeModel.setLastName("fouad");
        employeeModel.setEmail("abc@gmail.com");

        Employee employee = mapper.map(employeeModel, Employee.class);
        assertEquals(employeeModel.getFirstName(), employee.getFirstName());
        assertEquals(employeeModel.getLastName(), employee.getLastName());
        assertEquals(employeeModel.getEmail(), employee.getEmail());
    }



}
