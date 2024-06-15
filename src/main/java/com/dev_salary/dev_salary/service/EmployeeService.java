package com.dev_salary.dev_salary.service;

import com.dev_salary.dev_salary.domain.Employee;
import com.dev_salary.dev_salary.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
       return employeeRepository.findAll();
    }

    public Employee getEmployee(int id){
        Optional<Employee> employee =  employeeRepository.findById(id);
        if(employee.isEmpty()){
            return null;
        }
            return employee.get();
    }

    @Transactional
    public Employee postEmployee(Employee employee){
        Optional<Employee> response = Optional.of(employeeRepository.save(employee));
        if(response.isEmpty()){
            return null;
        }
        return response.get();
    }
    @Transactional
    public Employee updateEmployee(Employee employee, int id){
        Optional<Employee> response;
        if(employeeRepository.existsById(id)) {
            response = Optional.of(employeeRepository.save(employee));
        }else{
            return null;
        }
        return response.get();
    }

    public void deleteEmployee(int id){
       employeeRepository.deleteById(id);
    }

}
