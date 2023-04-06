package com.organizationService.repository;

import com.organizationService.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    public Organization findByOrganizationCode(String organizationCode);
}

