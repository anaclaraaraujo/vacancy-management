package br.com.anaclaraaraujo.vacancymanagement.modules.company.useCases;

import br.com.anaclaraaraujo.vacancymanagement.exceptions.CompanyNotFoundException;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories.CompanyRepository;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories.JobRepository;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(CompanyNotFoundException::new);

        return this.jobRepository.save(jobEntity);
    }
}