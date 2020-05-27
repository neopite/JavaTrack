package com.company.lab5.view;

import com.company.lab5.model.Teacher;

import java.util.Arrays;

public class MainView {

    public MainView() {
    }

    public static void printMenu() {
        System.out.println('\n');
        System.out.println(
                "1 : Print all teachers \n" +
                        "2 : Find teachers by input department \n" +
                        "3 : Find teachers by input discipline \n" +
                        "4 : Find teachers woman with rank of assistant professor \n"
                        + "5 : Exit \n" +
                "6 : Create new array of teachers \n ");
    }

    public void print(String message) {
        System.out.println(message);
    }
    public void printErr(String err) {
        System.err.println(err);
    }


    public void printTeachers(Teacher[] teachers) {
        if (teachers.length == 0) {
            System.out.println("Teachers not founded");
            return;
        }
        String systemOutParametr = "%-13.13s%-13.13s%-15.15s%-13.13s%-40.40s%-13.13s%-17.17s%n";
        System.out.printf(systemOutParametr, "Name", "Surname", "ThirdName", "Gender", "Disciplines", "Department", "Rank");
        System.out.printf(systemOutParametr, "____", "_______", "_________", "_______", "____________", "____________", "____");
        for (int itter = 0; itter < teachers.length; itter++) {
            System.out.printf(systemOutParametr,
                    teachers[itter].getName(),
                    teachers[itter].getSurname(),
                    teachers[itter].getThirdName(),
                    teachers[itter].getGender(),
                    Arrays.toString(teachers[itter].getDisciplines()),
                    teachers[itter].getDepartment(),
                    teachers[itter].getRank());
        }
    }

}
