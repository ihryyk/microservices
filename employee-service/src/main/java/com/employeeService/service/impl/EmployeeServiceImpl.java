package com.employeeService.service.impl;

import com.employeeService.dto.ApiResponseDto;
import com.employeeService.dto.DepartmentDto;
import com.employeeService.dto.EmployeeDto;
import com.employeeService.dto.OrganizationDto;
import com.employeeService.entity.Employee;
import com.employeeService.exception.ResourceNotFoundException;
import com.employeeService.mapper.EmployeeMapper;
import com.employeeService.repository.EmployeeRepository;
import com.employeeService.service.DepartmentAPIClient;
import com.employeeService.service.EmployeeService;
import com.employeeService.service.OrganizationAPIClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentAPIClient departmentAPIClient;
    private OrganizationAPIClient organizationAPIClient;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.mapToEntity(employeeDto);
        return EmployeeMapper.INSTANCE.mapToDto(employeeRepository.save(employee));
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDto findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employee id", String.valueOf(id)));
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToDto(employee);
        DepartmentDto departmentDto = departmentAPIClient.findByDepartmentCode(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationAPIClient.findByOrganizationCode(employee.getOrganizationCode());
        return new ApiResponseDto(employeeDto, departmentDto, organizationDto);
    }

    public ApiResponseDto getDefaultDepartment(Long id, Exception ex) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employee id", String.valueOf(id)));
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToDto(employee);
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development department");
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationCode("RD002");
        organizationDto.setOrganizationName("R&D Organization");
        organizationDto.setOrganizationDescription("Research and Development organization");
        return new ApiResponseDto(employeeDto, departmentDto, organizationDto);
    }
}
