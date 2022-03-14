package com.enigma.rediscrudoperation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMap {
    private Map<Integer, Employee> empIdEmployeeMap;
}
