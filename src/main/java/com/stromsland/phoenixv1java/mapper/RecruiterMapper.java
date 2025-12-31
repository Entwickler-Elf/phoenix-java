package com.stromsland.phoenixv1java.mapper;

import com.stromsland.phoenixv1java.dto.response.RecruiterResponseDTO;
import com.stromsland.phoenixv1java.entity.RecruiterEntity;
import org.springframework.stereotype.Component;

@Component
public class RecruiterMapper {
    public RecruiterResponseDTO toResponseDto(RecruiterEntity entity) {
        return new RecruiterResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getTelephone(),
                entity.getEmail(),
                entity.getRecruiterCompany() != null ? entity.getRecruiterCompany().getName() : null,
                entity.getCreatedAt()
        );
    }
}