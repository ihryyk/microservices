package com.employeeService.service.impl;

import com.employeeService.dto.EmployeeDto;
import com.employeeService.entity.Employee;
import com.employeeService.exception.ResourceNotFoundException;
import com.employeeService.mapper.EmployeeMapper;
import com.employeeService.repository.EmployeeRepository;
import com.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.mapToEntity(employeeDto);
        return EmployeeMapper.INSTANCE.mapToDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","employee id", String.valueOf(id)));
        return EmployeeMapper.INSTANCE.mapToDto(employee);
    }
}
