package com.epam;

import com.epam.employee.models.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeModel saveEmployee(EmployeeModel employeeModel);
    EmployeeModel updateEmployee(EmployeeModel employeeModel);
    List<EmployeeModel> getEmployees();
    EmployeeModel getEmployeeById(long id);
    EmployeeModel getEmployeeByEmail(String email);
    void deleteEmployee(EmployeeModel employeeModel);
    EmployeeModel findAllByFirstNameAndLastName(String firstName, String lastName);

}
