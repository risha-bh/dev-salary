package com.dev_salary.dev_salary.repository;

import com.dev_salary.dev_salary.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
