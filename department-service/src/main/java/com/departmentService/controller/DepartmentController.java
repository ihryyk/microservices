package com.departmentService.controller;

import com.departmentService.dto.DepartmentDto;
import com.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DepartmentDto save(@RequestBody DepartmentDto departmentDto) {
        return departmentService.save(departmentDto);
    }

    @GetMapping("{code}")
    @ResponseStatus(HttpStatus.OK)
    DepartmentDto findByDepartmentCode(@PathVariable String code){
        return departmentService.findByDepartmentCode(code);
    }
}
