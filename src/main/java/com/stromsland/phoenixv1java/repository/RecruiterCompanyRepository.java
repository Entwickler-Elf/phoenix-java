package com.stromsland.phoenixv1java.repository;

import com.stromsland.phoenixv1java.entity.RecruiterCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterCompanyRepository extends JpaRepository<RecruiterCompanyEntity, Long> {
}
