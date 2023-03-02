package com.employeeService.mapper;

import com.employeeService.dto.EmployeeDto;
import com.employeeService.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
   EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

   EmployeeDto mapToDto(Employee employee);

   Employee mapToEntity(EmployeeDto employeeDto);
}
