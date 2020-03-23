package com.epam;

import com.epam.employee.models.EmployeeModel;
import com.epam.employee.repo.dao.EmployeeDaoImp;
import com.epam.employee.repo.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeDaoImp employeeDaoImp;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employeeModel){
        Employee createdEmployee = employeeDaoImp.save(toEntity(employeeModel));
        return toModel(createdEmployee);
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employeeModel) {
        Employee createdEmployee = employeeDaoImp.save(toEntity(employeeModel));
        return toModel(createdEmployee);
    }

    @Override
    public List<EmployeeModel> getEmployees() {
        List<Employee> posts = employeeDaoImp.findAll();
        return posts.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeModel getEmployeeById(long id) {
        return toModel(employeeDaoImp.findById(id).get());
    }

    @Override
    public EmployeeModel getEmployeeByEmail(String email) {
        return toModel(employeeDaoImp.findAllByEmail(email));
    }

    @Override
    public void deleteEmployee(EmployeeModel employeeModel) {
         employeeDaoImp.delete(toEntity(employeeModel));
    }

    @Override
    public EmployeeModel findAllByFirstNameAndLastName(String firstName, String lastName) {
        return toModel(employeeDaoImp.findAllByFirstNameAndLastName(firstName,lastName));
    }

    private EmployeeModel toModel(Employee employee) {
        EmployeeModel employeeModel = modelMapper.map(employee, EmployeeModel.class);
        return employeeModel;
    }
    private Employee toEntity(EmployeeModel employeeModel) {
        Employee employee = modelMapper.map(employeeModel, Employee.class);
        return employee;
    }
}
