package com.epam.employee.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.epam.employee.constants.URIs;
import com.epam.employee.models.EmployeeModel;
import com.epam.employee.repo.entities.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class EmployeeControllerTests extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void addEmployee() throws Exception {
        String uri = URIs.api+URIs.version+URIs.employee+URIs.add;
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setFirstName("ibrahim");
        employeeModel.setLastName("fouad");
        employeeModel.setEmail("abfffcd@gmail.com");
        String inputJson = super.mapToJson(employeeModel);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }
    @Test
    public void updateEmployee() throws Exception {
        String uri =  URIs.api+URIs.version+URIs.employee+URIs.update;
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(1);
        employeeModel.setFirstName("sara");
        String updatedInputJson = super.mapToJson(employeeModel);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(updatedInputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
     }

    @Test
    public void getEmployeeList() throws Exception {
        String uri = URIs.api+URIs.version+URIs.employee+URIs.getAll;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeModel[] employeeModels = super.mapFromJson(content, EmployeeModel[].class);
        assertTrue(employeeModels.length > 0);
    }
    @Test
    public void deleteEmployee() throws Exception {
        String uri = URIs.api+URIs.version+URIs.employee+URIs.delete;
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(4);
        String deleteInputJson = super.mapToJson(employeeModel);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(deleteInputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }
}
