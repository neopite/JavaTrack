package com.company.neophite.exception;

public class InvalidDisciplineFormatException extends RuntimeException{
    public InvalidDisciplineFormatException(String discipline){
        super("Dicipline \""+discipline+"\" contains invalid sybmols . Type of exception : "+ InvalidDisciplineFormatException.class);
    }
}
