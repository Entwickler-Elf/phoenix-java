package com.stromsland.phoenixv1java.service.impl;

import com.stromsland.phoenixv1java.dto.response.RecruiterResponseDTO;
import com.stromsland.phoenixv1java.entity.RecruiterEntity;
import com.stromsland.phoenixv1java.mapper.RecruiterMapper;
import com.stromsland.phoenixv1java.repository.RecruiterRepository;
import com.stromsland.phoenixv1java.service.RecruiterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository repository;
    private final RecruiterMapper mapper;

    public RecruiterServiceImpl(RecruiterRepository repository, RecruiterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RecruiterResponseDTO> findAll() {
        List<RecruiterEntity> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toResponseDto)
                .toList();
    }
}
