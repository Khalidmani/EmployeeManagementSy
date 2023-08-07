
package com.Employee.employee.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data

public class Employee {

    private int Id;
    private String Employee_Name;
    private String Address;

    public Employee(int id, String employee_Name, String address) {
        Id = id;
        Employee_Name = employee_Name;
        Address = address;
    }

    public int getId() {
        return Id;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

