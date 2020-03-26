package com.epam.employee.rest.controllers;

import com.epam.employee.models.EmployeeModel;
import com.epam.employee.service.EmployeeService;
import com.epam.employee.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;



    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeModel employeeModel){
        if(employeeServiceImp.getEmployeeByEmail(employeeModel.getEmail())==null) {
             employeeServiceImp.saveEmployee(employeeModel);
             return new ResponseEntity<String>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>(HttpStatus.IM_USED);
        }
    }
    @PostMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus
            .OK)
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employeeModel){
        if(employeeServiceImp.getEmployeeByEmail(employeeModel.getEmail())!=null)
          return employeeServiceImp.updateEmployee(employeeModel);
        else
            return null;
    }
    @DeleteMapping(value = "/delete", produces = "application/json")
    public HttpStatus deleteEmployee(@RequestBody EmployeeModel employeeModel) {
        if(employeeServiceImp.getEmployeeByEmail(employeeModel.getEmail())!=null) {
            employeeServiceImp.deleteEmployee(employeeModel);
            return HttpStatus.OK;
        }
        else
             return HttpStatus.NOT_FOUND;
    }

    @GetMapping(value = "/getall", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<EmployeeModel> getEmployees() {
        return employeeServiceImp.getEmployees();
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeModel getEmployeeById(@PathVariable long id)
    {
        return employeeServiceImp.getEmployeeById(id);
    }


}
