package br.com.anaclaraaraujo.vacancymanagement.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe");
    }
}
