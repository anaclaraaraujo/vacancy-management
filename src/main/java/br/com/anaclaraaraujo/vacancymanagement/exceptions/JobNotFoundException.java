package br.com.anaclaraaraujo.vacancymanagement.exceptions;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException() {
        super("Job not found");
    }
}