package com.organizationService.mapper;

import com.organizationService.dto.OrganizationDto;
import com.organizationService.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {
    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    OrganizationDto mapToDto(Organization organization);

    Organization mapToEntity(OrganizationDto organizationDto);
}
