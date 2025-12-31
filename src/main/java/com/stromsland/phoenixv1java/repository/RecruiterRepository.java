package com.stromsland.phoenixv1java.repository;

import com.stromsland.phoenixv1java.entity.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Long> {
}
