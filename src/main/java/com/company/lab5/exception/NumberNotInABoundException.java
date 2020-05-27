package com.company.lab5.exception;

public class NumberNotInABoundException extends RuntimeException {
    public NumberNotInABoundException(String number){
        super("Number : " + number + " not in a bound from 1 to 5 ."+"Type of exception : "+ NumberNotInABoundException.class);
    }
}
