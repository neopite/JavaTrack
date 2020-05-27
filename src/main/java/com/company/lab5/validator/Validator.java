package com.company.lab5.validator;

import com.company.lab5.exception.InvalidDisciplineFormatException;
import com.company.lab5.exception.InvalidFormatDepartmentException;
import com.company.lab5.exception.NumberNotInABoundException;
import com.company.lab5.util.Util;

public class Validator {


    public static void validateChoosingNumberOfMenu(String numberOfMenu) {
        try {
            Integer.parseInt(numberOfMenu);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        if (Integer.parseInt(numberOfMenu) > 7 || Integer.parseInt(numberOfMenu) < 1) {
            throw new NumberNotInABoundException(numberOfMenu);
        }
    }

    public static void validateInputDepartment(String department)  {
        if(Util.isStringHasNumbers(department)){
            throw new InvalidFormatDepartmentException(department);
        }
    }


    public static void validateInputDiscipline(String discipline) {
        if(Util.isStringHasNumbers(discipline)){
            throw new InvalidDisciplineFormatException(discipline);
        }
    }
}
