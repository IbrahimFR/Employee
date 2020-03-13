package com.epam.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.epam.repo.dao.EmployeeDaoImp;
import com.epam.repo.entities.Employee;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest(classes = Application.class)
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
        Employee employee2 = employeeDaoImp.findAllByFistNameAndLastName("ibrahim","fouad");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

//    @Test
//    public void testGetEmployee() {
//
//        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
//        employeeRepository.save(employee);
//        Employee employee2 = employeeRepository.findByFirstName("admin");
//        assertNotNull(employee);
//        assertEquals(employee2.getFirstName(), employee.getFirstName());
//        assertEquals(employee2.getLastName(), employee.getLastName());
//    }
//
//    @Test
//    public void testDeleteEmployee() {
//        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
//        employeeRepository.save(employee);
//        employeeRepository.delete(employee);
//    }
//
//    @Test
//    public void findAllEmployees() {
//        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
//        employeeRepository.save(employee);
//        assertNotNull(employeeRepository.findAll());
//    }
//
//    @Test
//    public void deletByEmployeeIdTest() {
//        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
//        Employee emp = employeeRepository.save(employee);
//        employeeRepository.deleteById(emp.getId());
//    }
}
