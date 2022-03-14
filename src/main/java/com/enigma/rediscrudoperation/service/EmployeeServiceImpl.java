package com.enigma.rediscrudoperation.service;

import com.enigma.rediscrudoperation.model.Employee;
import com.enigma.rediscrudoperation.model.EmployeeId;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class EmployeeServiceImpl implements EmployeeService {
    private final String hashReference = "employee_info";

    @Resource(name = "redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Employee> hashOperations;

    @Override
    public void saveEmployee(Employee emp) {
        //creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, emp.getEmpId(), emp);
        System.out.println("hashOperations.putIfAbsent(hashReference, emp.getEmpId(), emp) = " + hashOperations.putIfAbsent(hashReference, emp.getEmpId(), emp));
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        hashOperations.putAll(hashReference, map);
    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        hashOperations.put(hashReference, emp.getEmpId(), emp);
        return getOneEmployee(emp.getEmpId());
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public Integer deleteEmployee(EmployeeId employeeId) {
        hashOperations.delete(hashReference, employeeId.getEmpId());
        return employeeId.getEmpId();
    }
}
