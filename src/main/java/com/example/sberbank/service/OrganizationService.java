package com.example.sberbank.service;

import com.example.sberbank.dto.OrganizationDto;
import com.example.sberbank.model.Organization;
import com.example.sberbank.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public Organization getOrCreate(OrganizationDto dto) {
        return organizationRepository.findByInnAndKpp(dto.getInn(), dto.getKpp())
                .orElseGet(() -> organizationRepository.save(
                        Organization.builder()
                                .name(dto.getName())
                                .inn(dto.getInn())
                                .kpp(dto.getKpp())
                                .build()
                ));
    }
}

