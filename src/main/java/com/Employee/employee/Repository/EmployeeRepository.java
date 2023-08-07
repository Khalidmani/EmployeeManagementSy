package com.Employee.employee.Repository;

import com.Employee.employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EmployeeRepository extends JpaRepository <Employee,Integer> {
}
