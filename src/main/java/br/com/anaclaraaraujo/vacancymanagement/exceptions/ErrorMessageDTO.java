package br.com.anaclaraaraujo.vacancymanagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.*;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String message;
    private String details;
}
