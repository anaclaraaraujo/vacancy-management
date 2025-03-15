package br.com.anaclaraaraujo.vacancymanagement.modules.company.controllers;

import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.CandidateEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.CompanyEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.useCases.CreateCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
@Tag(name = "Empresa", description = "Informações da empresa")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

   @PostMapping("/")
   @Operation(summary = "Cadastro da empresa", description = "Essa função é responsável por cadastrar um empresa")
   @ApiResponses({
           @ApiResponse(responseCode = "200", content = {
                   @Content(schema = @Schema(implementation = CandidateEntity.class))
           }),
           @ApiResponse(responseCode = "400", description = "Empresa já existe")
   })
   public ResponseEntity<Object> execute(@Valid @RequestBody CompanyEntity companyEntity) {
       try {
           var result = createCompanyUseCase.execute(companyEntity);
           return ResponseEntity.ok().body(result);
       } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
   }
}