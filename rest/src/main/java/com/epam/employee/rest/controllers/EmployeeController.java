package com.epam.employee.rest.controllers;

import com.epam.employee.models.EmployeeModel;
import com.epam.employee.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;



    @PostMapping("/add")
    public HttpStatus saveEmployee(@RequestBody EmployeeModel employeeModel){
        if(employeeServiceImp.getEmployeeByEmail(employeeModel.getEmail())==null) {
             employeeServiceImp.saveEmployee(employeeModel);
             return HttpStatus.CREATED;
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employeeModel){
        if(employeeServiceImp.getEmployeeByEmail(employeeModel.getEmail())!=null)
          return employeeServiceImp.updateEmployee(employeeModel);
        else
            return null;
    }
    @DeleteMapping("/delete")
    public HttpStatus deleteEmployee(@RequestBody EmployeeModel employeeModel) {
        if(employeeServiceImp.getEmployeeByEmail(employeeModel.getEmail())!=null) {
            employeeServiceImp.deleteEmployee(employeeModel);
            return HttpStatus.OK;
        }
        else
             return HttpStatus.NOT_FOUND;
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<EmployeeModel> getEmployees() {
        return employeeServiceImp.getEmployees();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeModel getEmployeeById(@PathVariable long id)
    {
        return employeeServiceImp.getEmployeeById(id);
    }


}
