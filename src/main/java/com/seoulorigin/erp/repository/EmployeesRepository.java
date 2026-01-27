package com.seoulorigin.erp.repository;

import com.seoulorigin.erp.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    List<Employees> findByDepartment(String department);
    List<Employees> findByPosition(String position);
    List<Employees> findByDepartmentAndPosition(String department, String position);
}
