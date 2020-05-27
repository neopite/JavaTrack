package com.company.lab4;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, int[]> journal = JournalGenerator.generateJournal(new String[]{"Jhon", "Spenser", "Tom", "Man","Andrew","Yarik"});
    private static final Map<String, int[]> badStudents = JournalUtil.findBadStudents(journal);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            makeChoice(scanner.nextInt());
        }
    }

    private static void makeChoice(int choice) {
        switch (choice) {
            case 1:
                printBadStudents(badStudents);
                break;
            case 2:
                printStudents(journal);
                break;
            case 3:

                System.exit(-1);
                break;
        }
    }

    private static void printMenu() {
        System.out.println("1. Print all bad students \n" +
                "2. Print all students \n" +
                "3. Exit "
        );
    }

    private static void printBadStudents(Map<String, int[]> students){
        if (students.isEmpty()) {
            System.out.println("Empty hashMap with bad students \n");
        } else {
            printStudents(students);
        }
    }

    private static void printStudents(Map<String, int[]> students) {
            for (Map.Entry<String, int[]> student : students.entrySet()) {
                System.out.println("Name : " + student.getKey() + " | marks : " + Arrays.toString(student.getValue()) + " | AVG  : " + JournalUtil.avgOfArray(student.getValue()));
            }
            System.out.println();
        }
    }

