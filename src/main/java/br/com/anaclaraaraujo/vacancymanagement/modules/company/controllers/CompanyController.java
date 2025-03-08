package br.com.anaclaraaraujo.vacancymanagement.modules.company.controllers;

import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.CompanyEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.useCases.CreateCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

   @PostMapping("/")
   public ResponseEntity<Object> execute(@Valid @RequestBody CompanyEntity companyEntity) {
       try {
           var result = createCompanyUseCase.execute(companyEntity);
           return ResponseEntity.ok().body(result);
       } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
   }
}