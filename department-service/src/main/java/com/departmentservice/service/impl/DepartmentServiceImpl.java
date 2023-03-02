package com.departmentservice.service.impl;

import com.departmentservice.dto.DepartmentDto;
import com.departmentservice.entity.Department;
import com.departmentservice.exception.EntityNotFindException;
import com.departmentservice.mapper.DepartmentMapper;
import com.departmentservice.repository.DepartmentRepository;
import com.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    public DepartmentDto findByDepartmentCode(String departmentCode) {
       Department department = Optional.of(departmentRepository.findDepartmentByDepartmentCode(departmentCode)).orElseThrow(()-> new EntityNotFindException(String.format("department with code = %s not found", departmentCode)));
            return DepartmentMapper.INSTANCE.mapToDto(department);


    }
}
