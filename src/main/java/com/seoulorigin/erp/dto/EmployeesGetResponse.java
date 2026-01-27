package com.seoulorigin.erp.dto;

import com.seoulorigin.erp.domain.Employees;

public record EmployeesGetResponse(
        Long id,
        String name,
        String department,
        String position
) {
    public static EmployeesGetResponse from(Employees employees) {
        return new EmployeesGetResponse(
                employees.getId(),
                employees.getName(),
                employees.getDepartment(),
                employees.getPosition()
        );
    }
}
