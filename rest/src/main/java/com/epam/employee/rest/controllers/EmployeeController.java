package com.epam.employee.rest.controllers;

import com.epam.employee.constants.URIs;
import com.epam.employee.models.EmployeeModel;
import com.epam.employee.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = URIs.api+URIs.version)
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;



    @PostMapping(value = URIs.add, produces = "application/json")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeModel employeeModel){
        if(employeeServiceImp.getEmployeeByEmail(employeeModel.getEmail())==null) {
             employeeServiceImp.saveEmployee(employeeModel);
             return new ResponseEntity<String>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>(HttpStatus.IM_USED);
        }
    }
    @PutMapping(value = URIs.update, produces = "application/json")
    public ResponseEntity<EmployeeModel>  updateEmployee(@RequestBody EmployeeModel employeeModel){

        if(employeeServiceImp.getEmployeeById(employeeModel.getId())!=null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(employeeServiceImp.updateEmployee(employeeModel));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(employeeModel);
    }
    @DeleteMapping(value = URIs.delete, produces = "application/json")
    public ResponseEntity<EmployeeModel>  deleteEmployee(@RequestBody EmployeeModel employeeModel) {
        if(employeeServiceImp.getEmployeeById(employeeModel.getId())!=null) {
            employeeServiceImp.deleteEmployee(employeeModel);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(employeeServiceImp.updateEmployee(employeeModel));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(employeeModel);
    }

    @GetMapping(value = URIs.getAll, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<EmployeeModel> getEmployees() {
        return employeeServiceImp.getEmployees();
    }

    @GetMapping(value = URIs.getOne+"/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeModel getEmployeeById(@PathVariable long id)
    {
        return employeeServiceImp.getEmployeeById(id);
    }


}
