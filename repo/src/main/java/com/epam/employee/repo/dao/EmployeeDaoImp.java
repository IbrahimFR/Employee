package com.epam.employee.repo.dao;

import com.epam.employee.repo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDaoImp extends JpaRepository<Employee, Long> {
    Employee findAllByFirstNameAndLastName(String firstName, String lastName);
    Employee findAllByEmail(String email);
}
