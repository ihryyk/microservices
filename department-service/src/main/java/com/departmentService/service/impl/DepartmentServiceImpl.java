package com.departmentService.service.impl;

import com.departmentService.dto.DepartmentDto;
import com.departmentService.entity.Department;
import com.departmentService.exception.ResourceNotFoundException;
import com.departmentService.mapper.DepartmentMapper;
import com.departmentService.repository.DepartmentRepository;
import com.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.INSTANCE.mapToEntity(departmentDto);
        return DepartmentMapper.INSTANCE.mapToDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto findByDepartmentCode(String departmentCode) throws ResourceNotFoundException {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode).orElseThrow(() -> new ResourceNotFoundException("Department","department code", departmentCode));
        return DepartmentMapper.INSTANCE.mapToDto(department);


    }
}
