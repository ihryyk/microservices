package com.departmentservice.service;

import com.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    public DepartmentDto save(DepartmentDto departmentDto);
    public DepartmentDto findByDepartmentCode(String departmentCode);
}
