package com.departmentService.service;

import com.departmentService.dto.DepartmentDto;

public interface DepartmentService {
    public DepartmentDto save(DepartmentDto departmentDto);
    public DepartmentDto findByDepartmentCode(String departmentCode);
}
