package com.example.sberbank.repository;

import com.example.sberbank.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    Optional<Organization> findByInnAndKpp(String inn, String kpp);
}

