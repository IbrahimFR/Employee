package com.epam.employee.repo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.epam.employee.repo.entities.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeDaoImpTests {


    @Autowired
   private EmployeeDaoImp employeeDaoImp;

    @Test
    public void testSaveEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("ibrahim");
        employee.setLastName("fouad");
        employee.setEmail("abc@gmail.com");
        employee.setPassword("123456");
        employeeDaoImp.save(employee);
        Employee employee2 = employeeDaoImp.findAllByFirstNameAndLastName("ibrahim","fouad");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

    @Test
    public void testGetEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("ibrahim");
        employee.setLastName("fouad");
        employee.setEmail("abc@gmail.com");
        employee.setPassword("123456");
        employeeDaoImp.save(employee);
        Employee employee2 = employeeDaoImp.findAllByFirstNameAndLastName("ibrahim","fouad");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("ibrahim");
        employee.setLastName("fouad");
        employee.setEmail("abc@gmail.com");
        employee.setPassword("123456");
        employeeDaoImp.save(employee);
        employeeDaoImp.delete(employee);
    }

    @Test
    public void findAllEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("ibrahim");
        employee.setLastName("fouad");
        employee.setEmail("abc@gmail.com");
        employee.setPassword("123456");
        employeeDaoImp.save(employee);
        assertNotNull(employeeDaoImp.findAll());
    }

}
