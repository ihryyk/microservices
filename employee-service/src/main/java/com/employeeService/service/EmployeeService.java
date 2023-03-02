package com.employeeService.service;

import com.employeeService.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto save (EmployeeDto employeeDto);
    public EmployeeDto findById (Long id);
}
