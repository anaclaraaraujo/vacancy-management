package br.com.anaclaraaraujo.vacancymanagement.modules.candidate.useCases;

import br.com.anaclaraaraujo.vacancymanagement.exceptions.JobNotFoundException;
import br.com.anaclaraaraujo.vacancymanagement.exceptions.UserNotFoundException;
import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.CandidateRepository;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    public void execute(UUID idCandidate, UUID idJob) {
         // VALIDAR SE O CANDIDATO EXISTE
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(UserNotFoundException::new);

        // VALIDAR SE A VAGA EXISTE
        this.jobRepository.findById(idJob)
                .orElseThrow(JobNotFoundException::new);


        // CANDIDATO SE INSCREVE NA VAGA

    }
}
