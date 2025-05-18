package br.com.anaclaraaraujo.vacancymanagement.modules.candidate.repository;

import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.entity.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
