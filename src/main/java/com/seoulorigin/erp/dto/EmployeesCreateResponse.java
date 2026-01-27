package com.seoulorigin.erp.dto;

import com.seoulorigin.erp.domain.Employees;

public record EmployeesCreateResponse(
    Long id
) {
    public static EmployeesCreateResponse getId(Employees employees) {
        return new EmployeesCreateResponse(employees.getId());
    }
}
