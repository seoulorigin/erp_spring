package com.seoulorigin.erp.dto;

public record EmployeesCreateRequest(
    String name,
    String department,
    String position
) {
}
