package br.com.anaclaraaraujo.vacancymanagement.modules.company.controllers;

import br.com.anaclaraaraujo.vacancymanagement.modules.company.dto.CreateJobDTO;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.JobEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.useCases.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder()
                .companyId(UUID.fromString(companyId.toString()))
                .description(createJobDTO.getDescription())
                .benefits(createJobDTO.getBenefitis())
                .level(createJobDTO.getLevel())
                .build();

        return createJobUseCase.execute(jobEntity);
    }
}
