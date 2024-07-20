package com.example.em_project;

import java.util.List;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import logger.CLog;

@RestController
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getEmployees() {
        CLog.log("Called API get all employees");
        return employeeService.getEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        CLog.log("Called API get all employees");
        return employeeService.getEmployee(id);
    }

    @PostMapping("employees")
    public Response setEmp(@RequestBody @Nullable EmployeeResponse employee){
        CLog.log("Called API set all employees");
        Response response;
        if(employee == null){
            response = new ErrorApiResponse("Employee Data is NULL", "NULL");
        }
        else {
            Employee employeeResponse =  employeeService.createEmployee(employee);
            CLog.log("Data Added Successfully with id" + employeeResponse.getId());
            response = new SuccessApiResponse("Data Added Successfully", employeeResponse);
        }
        return  response;
    }

    @DeleteMapping("employees/{id}")
    public Response deleteEmployee(@PathVariable Long id){
        CLog.log("Delete Employee Called");
        Response response;
        if(employeeService.deleteEmployee(id)){
            response = new SuccessApiResponse("Employee Removed Successfully", id);
        }
        else {
            response = new ErrorApiResponse("Error Deleting Employee", "Employee Not Found!");
        }
        return  response;
    }
}
