package com.stromsland.phoenixv1java.repository;

import com.stromsland.phoenixv1java.TestcontainersConfiguration;
import com.stromsland.phoenixv1java.config.JpaConfig;
import com.stromsland.phoenixv1java.entity.RecruiterCompanyEntity;
import com.stromsland.phoenixv1java.entity.RecruiterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@Import({TestcontainersConfiguration.class, JpaConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RecruiterRepositoryTest  {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Test
    void shouldSaveAndFindRecruiter() {
        // Given
        RecruiterCompanyEntity company = new RecruiterCompanyEntity();
        company.setName("John Smith");
        company.setCompany("Tech Corp");
        company.setEmail("contact@techcorp.com");
        company.setTelephone("12345678");
        entityManager.persist(company);

        RecruiterEntity recruiter = new RecruiterEntity();
        recruiter.setName("Jane Doe");
        recruiter.setEmail("jane@example.com");
        recruiter.setTelephone("12345678");
        recruiter.setRecruiterCompany(company);

        // When
        RecruiterEntity savedRecruiter = recruiterRepository.save(recruiter);

        // Then
        assertThat(savedRecruiter.getId()).isNotNull();
        assertThat(savedRecruiter.getName()).isEqualTo("Jane Doe");
        assertThat(savedRecruiter.getRecruiterCompany().getName()).isEqualTo("John Smith");
    }

}