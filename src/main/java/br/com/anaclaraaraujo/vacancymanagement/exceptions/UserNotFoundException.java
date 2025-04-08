package br.com.anaclaraaraujo.vacancymanagement.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found");
    }
}
