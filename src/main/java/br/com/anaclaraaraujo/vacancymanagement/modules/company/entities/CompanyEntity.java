package br.com.anaclaraaraujo.vacancymanagement.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "The [username] field must not contain spaces")
    @Schema(example = "muststart")
    private String username;

    @Email(message = "The [email] field must contain a valid email address")
    @Schema(example = "muststart@email.com")
    private String email;

    @Length(min = 10, max = 100, message = "Password must contain between (10) and (100) characters")
    @Schema(example = "admin@bash098")
    private String password;

    @Schema(example = "muststart.com.br")
    private String website;

    @Schema(example = "Must Start")
    private String name;

    @Schema(example = "Unicornio de Tecnologia")
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}