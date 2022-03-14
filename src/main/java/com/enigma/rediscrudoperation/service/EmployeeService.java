package com.enigma.rediscrudoperation.service;

import com.enigma.rediscrudoperation.model.Employee;
import com.enigma.rediscrudoperation.model.EmployeeId;

import java.util.Map;

public interface EmployeeService {

    void saveEmployee(Employee emp);

    Employee getOneEmployee(Integer id);

    Employee updateEmployee(Employee emp);

    Map<Integer, Employee> getAllEmployees();

    Integer deleteEmployee(EmployeeId employeeId);

    void saveAllEmployees(Map<Integer, Employee> map);

}
