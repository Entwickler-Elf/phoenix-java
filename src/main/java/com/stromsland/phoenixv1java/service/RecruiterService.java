package com.stromsland.phoenixv1java.service;

import com.stromsland.phoenixv1java.dto.response.RecruiterResponseDTO;

import java.util.List;

public interface RecruiterService {
    List<RecruiterResponseDTO> findAll();
}
