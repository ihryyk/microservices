package com.departmentService.mapper;

import com.departmentService.dto.DepartmentDto;
import com.departmentService.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDto(Department department);

    Department mapToEntity(DepartmentDto departmentDto);
}
