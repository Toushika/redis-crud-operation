package com.enigma.rediscrudoperation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeId implements Serializable {
    private static final long serialVersionUID = -7817224776021728682L;

    private Integer empId;
}
