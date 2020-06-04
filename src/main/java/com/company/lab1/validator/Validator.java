package com.company.lab1.validator;

import com.company.lab1.exception.InvalidDisciplineFormatException;
import com.company.lab1.exception.InvalidFormatDepartmentException;
import com.company.lab1.exception.NumberNotInABoundException;
import com.company.lab1.util.Util;

public class Validator {


    public static void validateChoosingNumberOfMenu(String numberOfMenu) {
        try {
            Integer.parseInt(numberOfMenu);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        if (Integer.parseInt(numberOfMenu) > 6 || Integer.parseInt(numberOfMenu) < 1) {
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
