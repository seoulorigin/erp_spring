package com.seoulorigin.erp.service;

import com.seoulorigin.erp.domain.Employees;
import com.seoulorigin.erp.dto.EmployeesCreateRequest;
import com.seoulorigin.erp.dto.EmployeesCreateResponse;
import com.seoulorigin.erp.dto.EmployeesUpdateRequest;
import com.seoulorigin.erp.repository.EmployeesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    // 1. 직원 생성
    @Transactional
    public EmployeesCreateResponse postEmployees(Employees employees) {
        employeesRepository.save(employees);
        return EmployeesCreateResponse.getId(employees);
    }

    // 2-1. 직원 목록 조회
    @Transactional
    public List<Employees> getEmployees(String department, String position) {
        if (department != null && position != null)
            return employeesRepository.findByDepartmentAndPosition(department, position);
        else if (department != null)
            return employeesRepository.findByDepartment(department);
        else if (position != null)
            return employeesRepository.findByPosition(position);
        else
            return employeesRepository.findAll();
    }

    // 2-2. 직원 상세 조회
    @Transactional
    public Employees getEmployeesDetail(Long id) {
        return employeesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Failed."));
    }

    // 3. 직원 수정
    @Transactional
    public void updateEmployees(Long id, EmployeesUpdateRequest request) {
        Employees employees = employeesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Failed."));

        employees.update(request.department(), request.position());
    }

    // 4. 직원 삭제
    @Transactional
    public void deleteEmployees(Long id) {
        Employees employees = employeesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Failed."));

        employeesRepository.delete(employees);
    }
}
