package com.seoulorigin.erp.contorller;

import com.seoulorigin.erp.domain.Employees;
import com.seoulorigin.erp.dto.EmployeesCreateRequest;
import com.seoulorigin.erp.dto.EmployeesCreateResponse;
import com.seoulorigin.erp.dto.EmployeesGetResponse;
import com.seoulorigin.erp.dto.EmployeesUpdateRequest;
import com.seoulorigin.erp.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeesContorller {
    private final EmployeesService employeesService;

    @PostMapping
    public EmployeesCreateResponse postEmployees(@RequestBody EmployeesCreateRequest request) {
        Employees employees = new Employees(
                request.name(),
                request.department(),
                request.position()
        );
        return employeesService.postEmployees(employees);
    }

    @GetMapping
    public List<EmployeesGetResponse> getEmployees(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String position
    ) {
        return employeesService.getEmployees(department, position).stream()
                .map(EmployeesGetResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public EmployeesGetResponse getEmployeesDetail(@PathVariable Long id) {
        Employees employees = employeesService.getEmployeesDetail(id);
        return EmployeesGetResponse.from(employees);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateEmployees(
            @PathVariable Long id,
            @RequestBody EmployeesUpdateRequest request
    ) {
        employeesService.updateEmployees(id, request);
    }
}
