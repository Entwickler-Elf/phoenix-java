package com.stromsland.phoenixv1java.controller;

import com.stromsland.phoenixv1java.dto.response.RecruiterResponseDTO;
import com.stromsland.phoenixv1java.service.RecruiterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController {

    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @GetMapping
    public ResponseEntity<List<RecruiterResponseDTO>> getAll() {
        return ResponseEntity.ok(recruiterService.findAll());
    }
}
