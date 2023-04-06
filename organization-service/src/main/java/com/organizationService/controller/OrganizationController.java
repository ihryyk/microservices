package com.organizationService.controller;

import com.organizationService.dto.OrganizationDto;
import com.organizationService.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/organizations")

public class OrganizationController {
    private OrganizationService organizationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationDto save(@RequestBody OrganizationDto organizationDto){
        return organizationService.save(organizationDto);
    }

    @GetMapping("{code}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationDto findByOrganizationCode(@PathVariable("code") String code){
        return organizationService.findByOrganizationCode(code);
    }
}
