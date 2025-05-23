package br.com.anaclaraaraujo.vacancymanagement.modules.candidate.useCases;

import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.JobEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContaining(filter);
    }
}
