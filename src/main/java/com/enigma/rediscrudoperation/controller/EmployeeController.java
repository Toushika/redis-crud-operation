package com.enigma.rediscrudoperation.controller;

import com.enigma.rediscrudoperation.model.Employee;
import com.enigma.rediscrudoperation.model.EmployeeId;
import com.enigma.rediscrudoperation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.info("EmployeeController :: saveEmployee :: Employee :: {}", employee);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PostMapping("/get-one-employee")
    public Employee getOneEmployee(@RequestBody EmployeeId employeeId) {
        System.out.println(employeeId);
        log.info("EmployeeController :: getOneEmployee :: Employee :: {}", employeeService.getOneEmployee(employeeId.getEmpId()));
        return employeeService.getOneEmployee(employeeId.getEmpId());
    }

    @PostMapping("/delete-employee")
    public String deleteEmployeeById(@RequestBody EmployeeId employeeId) {
        log.info("EmployeeController :: deleteEmployeeById :: employeeId :: {}",employeeId);
        return employeeService.deleteEmployee(employeeId) + " is deleted";
    }

    @PostMapping("/update-employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        log.info("EmployeeController :: updateEmployee  :: employee :: {} ", employee);
        return employeeService.updateEmployee(employee);
    }

    @PostMapping("/get-all-employees")
    public Map<Integer, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/save-all-employees")
    public String saveAllEmployees(@RequestBody Map<Integer, Employee> integerEmployeeMap) {
        log.info("EmployeeController :: saveAllEmployees  :: integerEmployeeMap :: {}", integerEmployeeMap);
        employeeService.saveAllEmployees(integerEmployeeMap);
        return "Data has been saved successfully";
    }

}
