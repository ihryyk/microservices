package com.employeeService.service;

import com.employeeService.dto.DepartmentDto;
import com.employeeService.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentAPIClient {

    @GetMapping("api/departments/{code}")
    @ResponseStatus(HttpStatus.OK)
    DepartmentDto findByDepartmentCode(@PathVariable String code);

}
