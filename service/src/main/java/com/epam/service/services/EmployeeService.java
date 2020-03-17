package com.epam.service;

import com.epam.employee.models.EmployeeModel;
import com.epam.repo.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    Employee saveEmployee(EmployeeModel employeeModel);

}
