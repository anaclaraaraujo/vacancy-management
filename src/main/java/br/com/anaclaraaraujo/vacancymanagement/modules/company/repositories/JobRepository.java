package br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories;

import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    List<JobEntity> findByDescriptionContaining(String filter);
}
