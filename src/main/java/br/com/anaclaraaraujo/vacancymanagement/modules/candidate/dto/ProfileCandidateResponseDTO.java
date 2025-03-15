package br.com.anaclaraaraujo.vacancymanagement.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {
    @Schema(example = "Desenvolvedora Java")
    private String description;

    @Schema(example = "ana")
    private String username;

    @Schema(example = "ana@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "Ana Clara Araujo")
    private String name;
}
