package br.com.anaclaraaraujo.vacancymanagement.modules.candidate;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.*;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "The [username] field must not contain spaces")
    private String username;

    @Email(message = "The [email] field must contain a valid email address")
    private String email;

    @Length(min = 10, max = 100, message = "Password must contain between (10) and (100) characters")
    private String password;

    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDate createdAt;
}