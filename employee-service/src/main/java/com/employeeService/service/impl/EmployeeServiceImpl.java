package com.employeeService.service.impl;

import com.employeeService.dto.ApiResponseDto;
import com.employeeService.dto.DepartmentDto;
import com.employeeService.dto.EmployeeDto;
import com.employeeService.entity.Employee;
import com.employeeService.exception.ResourceNotFoundException;
import com.employeeService.mapper.EmployeeMapper;
import com.employeeService.repository.EmployeeRepository;
import com.employeeService.service.APIClient;
import com.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private APIClient apiClient;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.mapToEntity(employeeDto);
        return EmployeeMapper.INSTANCE.mapToDto(employeeRepository.save(employee));
    }

    @Override
    public ApiResponseDto findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employee id", String.valueOf(id)));
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToDto(employee);
      DepartmentDto departmentDto = apiClient.findByDepartmentCode(employee.getDepartmentCode());
        return new ApiResponseDto(employeeDto, departmentDto);
    }
}
