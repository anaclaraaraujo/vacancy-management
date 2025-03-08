package br.com.anaclaraaraujo.vacancymanagement.modules.company.controllers;

import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.JobEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> execute(@Valid @RequestBody JobEntity jobEntity) {
        try {
            var result = createJobUseCase.execute(jobEntity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
