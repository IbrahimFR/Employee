package com.epam.repo.dao;

import com.epam.repo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDaoImp extends JpaRepository<Employee, Long> {
    Employee findByFistNameAndLastName(String firstName, String lastName);
}
