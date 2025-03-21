package br.com.anaclaraaraujo.vacancymanagement.modules.company.useCases;

import br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories.JobRepository;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}