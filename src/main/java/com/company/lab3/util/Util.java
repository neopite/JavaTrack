package com.company.lab3.util;

public class Util {
    public static boolean isStringHasNumbers(String value) {
        char [] arrayOfString = value.toCharArray();
        if(value.length()==0){
            return false;
        }
        for (int itter = 0; itter < arrayOfString.length; itter++) {
            if (Character.isDigit(arrayOfString[itter])) {
                return true;
            }
        }
        return false;
    }
}
