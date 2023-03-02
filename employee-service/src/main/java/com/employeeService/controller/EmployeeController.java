package com.employeeService.controller;

import com.employeeService.dto.EmployeeDto;
import com.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        return employeeService.save(employeeDto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeDto findById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }
}
