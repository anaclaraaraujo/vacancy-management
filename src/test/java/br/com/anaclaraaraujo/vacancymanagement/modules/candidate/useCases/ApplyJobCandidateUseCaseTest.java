package br.com.anaclaraaraujo.vacancymanagement.modules.candidate.useCases;

import br.com.anaclaraaraujo.vacancymanagement.exceptions.UserNotFoundException;
import br.com.anaclaraaraujo.vacancymanagement.modules.candidate.CandidateRepository;
import br.com.anaclaraaraujo.vacancymanagement.modules.company.repositories.JobRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Should not be able to aplly job with candidate not found")
    public void should_not_be_able_to_apply_job_with_candidate_not_found() {
        try{
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e){
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }
}
