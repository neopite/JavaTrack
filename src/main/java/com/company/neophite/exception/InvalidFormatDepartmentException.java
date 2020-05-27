package com.company.neophite.exception;

public class InvalidFormatDepartmentException extends RuntimeException {
    public InvalidFormatDepartmentException(String notExistedDepartment) {
        super("Department \"" + notExistedDepartment + "\" contains invalid symbols,try again . Type of exception : "+ InvalidFormatDepartmentException.class);
    }
}
