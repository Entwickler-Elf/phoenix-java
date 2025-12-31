package com.stromsland.phoenixv1java.dto.response;

import java.time.OffsetDateTime;

/**
 * A DTO for the {@link com.stromsland.phoenixv1java.entity.RecruiterEntity} entity
 */
public record RecruiterResponseDTO(Long id,
                                   String name,
                                   String telephone,
                                   String email,
                                   String recruiterCompanyName,
                                   OffsetDateTime createdAt) {
}
