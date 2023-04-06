package com.organizationService.service;

import com.organizationService.dto.OrganizationDto;

public interface OrganizationService {
    public OrganizationDto save(OrganizationDto organizationDto);
    public OrganizationDto findByOrganizationCode(String organizationCode);
}
