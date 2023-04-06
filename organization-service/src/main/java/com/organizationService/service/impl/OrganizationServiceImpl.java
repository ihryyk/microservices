package com.organizationService.service.impl;

import com.organizationService.dto.OrganizationDto;
import com.organizationService.entity.Organization;
import com.organizationService.mapper.OrganizationMapper;
import com.organizationService.repository.OrganizationRepository;
import com.organizationService.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;


    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.INSTANCE.mapToEntity(organizationDto);
        return OrganizationMapper.INSTANCE.mapToDto(organizationRepository.save(organization));
    }

    @Override
    public OrganizationDto findByOrganizationCode(String organizationCode) {
        return OrganizationMapper.INSTANCE.mapToDto(organizationRepository.findByOrganizationCode(organizationCode));
    }
}
