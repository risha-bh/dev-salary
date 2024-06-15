package com.dev_salary.dev_salary.controller;

import com.dev_salary.dev_salary.domain.Employee;
import com.dev_salary.dev_salary.service.EmployeeService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/empAll")
    public ResponseEntity<?> getAllEmployeeData(){
        List<Employee> data = employeeService.getAllEmployees();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/empAdd")
    public ResponseEntity<?> AddEmployee(@RequestBody Employee employee){
        Employee response = employeeService.postEmployee(employee);
        if(response == null){
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/empUpd/{id}")
    public ResponseEntity<?> UpdateEmployee(@PathVariable int id, @RequestBody Employee employee){
        Employee response = employeeService.updateEmployee(employee , id);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/empDlt/{id}")
    public ResponseEntity<?> DeleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
