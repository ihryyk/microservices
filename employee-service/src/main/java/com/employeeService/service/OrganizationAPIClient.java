package com.employeeService.service;

import com.employeeService.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationAPIClient {

    @GetMapping("api/organizations/{code}")
    @ResponseStatus(HttpStatus.OK)
    OrganizationDto findByOrganizationCode(@PathVariable String code);
}
