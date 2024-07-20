package com.example.em_project;

import logger.CLog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeResponse employee) {
        List<Employee> employees = employeeRepository.findAll();
        CLog.log("Find Length is " + employees.size());
        Employee last = employees.get(employees.size()-1);
        Employee employee1 = new Employee(employee.getName(), employee.getDepartment());
        BeanUtils.copyProperties(employee,employee1);
        employeeRepository.save(employee1);
        return employee1;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id){
        Optional<Employee> e =  employeeRepository.findById(id);
        CLog.log("Employee Data is " + e);
        return  e.get();
    }

    @Override
    public boolean deleteEmployee(Long id) {
        boolean response = false;
        try {
            employeeRepository.deleteById(id);
            response = true;
        } catch (Exception e){
            CLog.log("Error Deleting Employee");
        }
        return response;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee existingEmployee = employeeOptional.get();
            BeanUtils.copyProperties(employee, existingEmployee, "id"); // Copy properties except the id
            return employeeRepository.saveAndFlush(existingEmployee);
        }
        return null;
    }
}
