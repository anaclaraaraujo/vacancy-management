package br.com.anaclaraaraujo.vacancymanagement.modules.candidate.useCases;

import br.com.anaclaraaraujo.vacancymanagement.exceptions.JobNotFoundException;
import br.com.anaclaraaraujo.vacancymanagement.exceptions.UserNotFoundException;
import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.CandidateEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.CandidateRepository;
import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.entity.ApplyJobEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.repository.ApplyJobRepository;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.entities.JobEntity;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories.JobRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply for a job if candidate does not found")
    public void should_not_be_apply_job_with_candidate_not_found() {
        try{
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e){
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    public void should_be_able_to_create_a_new_apply_job(){
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder().candidateId(idCandidate)
                .jobId(idJob).build();

        var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));

        when(applyJobRepository.save(applyJob)).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate, idJob);

        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }
}
