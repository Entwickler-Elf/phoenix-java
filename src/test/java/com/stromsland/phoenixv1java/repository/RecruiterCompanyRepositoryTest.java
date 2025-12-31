package com.stromsland.phoenixv1java.repository;

import com.stromsland.phoenixv1java.TestcontainersConfiguration;
import com.stromsland.phoenixv1java.config.JpaConfig;
import com.stromsland.phoenixv1java.entity.RecruiterCompanyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@Import({TestcontainersConfiguration.class, JpaConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RecruiterCompanyRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

    @Autowired
    private RecruiterCompanyRepository recruiterCompanyRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldSaveAndFindRecruiterCompany() {
        RecruiterCompanyEntity company = new RecruiterCompanyEntity();
        company.setName("Jane Smith"); // The 'name' field
        company.setCompany("Tech Corp"); // The 'company' field
        company.setEmail("contact@techcorp.com");
        company.setTelephone("12345678");

        RecruiterCompanyEntity savedCompany = recruiterCompanyRepository.save(company);

        entityManager.flush();
        entityManager.clear();

        RecruiterCompanyEntity entity = recruiterCompanyRepository.findById(savedCompany.getId()).orElseThrow();

        assertThat(entity.getCompany()).isEqualTo("Tech Corp");
        assertThat(entity.getName()).isEqualTo("Jane Smith");
        assertThat(entity.getEmail()).isEqualTo("contact@techcorp.com");
        assertThat(entity.getTelephone()).isEqualTo("12345678");

    }

    @Test
    void shouldFindAllRecruiterCompanies() {
        RecruiterCompanyEntity company = new RecruiterCompanyEntity();
        company.setName("Jane Smith");
        company.setCompany("Tech Corp");
        company.setEmail("contact@techcorp.com");
        company.setTelephone("12345678");
        recruiterCompanyRepository.save(company);

        assertThat(recruiterCompanyRepository.findAll()).isNotEmpty();
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        RecruiterCompanyEntity company = new RecruiterCompanyEntity();
        company.setName(null);
        company.setCompany("Tech Corp");
        company.setEmail("contact@techcorp.com");
        company.setTelephone("12345678");
        // saveAndFlush is used to force the database integrity check immediately
        assertThrows(DataIntegrityViolationException.class, () -> {
            recruiterCompanyRepository.saveAndFlush(company);
        });
    }

}