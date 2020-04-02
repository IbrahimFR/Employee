package com.epam.employee.service;

import com.epam.employee.models.EmployeeModel;
import com.epam.employee.repo.dao.EmployeeDaoImp;
import com.epam.employee.repo.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
        Employee updatedEmployee = employeeDaoImp.save(toEntity(employeeModel));
        return toModel(updatedEmployee);
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
        Optional<Employee> employee = employeeDaoImp.findById(id);
        if(employee.isPresent()){
            return toModel(employee.get());
        }
        else
            return null;
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
        if(employee!=null)
            return modelMapper.map(employee, EmployeeModel.class);
        else
            return null;
    }
    private Employee toEntity(EmployeeModel employeeModel) {
        if(employeeModel!=null)
           return modelMapper.map(employeeModel, Employee.class);
        else
          return null;
    }
}
