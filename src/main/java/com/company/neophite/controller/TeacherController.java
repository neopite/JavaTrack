package com.company.neophite.controller;


import com.company.neophite.exception.InvalidDisciplineFormatException;
import com.company.neophite.exception.InvalidFormatDepartmentException;
import com.company.neophite.exception.NumberNotInABoundException;
import com.company.neophite.model.Teacher;
import com.company.neophite.service.TeacherService;
import com.company.neophite.util.TeacherGenerator;
import com.company.neophite.validator.Validator;
import com.company.neophite.view.MainView;
import com.company.neophite.view.RetrievView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.company.neophite.view.MainView.printMenu;

public class TeacherController {

    private static final int EXIT_CODE = 5;

    private TeacherService teacherService;
    private MainView mainView;
    private RetrievView retrievView;

    public TeacherController() {
        mainView = new MainView();
        retrievView = new RetrievView();
    }

    public void run() {
        readDataFromFile();
        if (this.teacherService == null) return;
        while (true) {
            printMenu();
            String data = retrievView.getNumberOfFuction();
            try {
                Validator.validateChoosingNumberOfMenu(data);
            } catch (NumberFormatException | NumberNotInABoundException e) {
                mainView.printErr("Please write numeric value from 1 to 6");
                continue;
            }
            if (Integer.parseInt(data) == EXIT_CODE) {
                try {
                    teacherService.writeDataToFile();
                } catch (FileNotFoundException e) {
                    mainView.printErr("File for writting is not found");
                } catch (IOException e) {
                    mainView.printErr("Data for writting in file can not be write");
                }
                mainView.print("Data was saved");
                return;
            }
            actions(Integer.parseInt(data));
        }
    }

    private void actions(int action) {
        switch (action) {
            case 1:
                getAllTeachers();
                break;
            case 2:
                getTeachersByDepartment();
                break;
            case 3:
                getTeachersByDiscipline();
                break;
            case 4:
                getWomanAndAssistantProffesor();
                break;
            case 6:
                setNewTeachers(TeacherGenerator.generateTeacher(10));
                break;


        }
    }

    private void getAllTeachers() {
        mainView.printTeachers(teacherService.getTeachers());
    }

    private void getTeachersByDepartment() {
        mainView.print("Enter Department : ");
        String department = retrievView.getArgument();
        try {
            Validator.validateInputDepartment(department);
        } catch (InvalidFormatDepartmentException e) {
            mainView.printErr(e.getMessage());
            getTeachersByDepartment();
        }
        mainView.printTeachers(teacherService.findTeachersByDepartment(department));
    }

    private void getTeachersByDiscipline() {
        mainView.print("Enter discipline : ");
        String discipline = retrievView.getArgument();
        try {
            Validator.validateInputDiscipline(discipline);
        } catch (InvalidDisciplineFormatException e) {
            mainView.printErr(e.getMessage());
            getTeachersByDiscipline();
        }
        mainView.printTeachers(teacherService.findTeachersByDiscipline(discipline));
    }

    private void getWomanAndAssistantProffesor() {
        mainView.printTeachers(teacherService.findTeachersWomanAndAssistanceProfessor());
    }

    private void setNewTeachers(Teacher[] teachers) {
        this.teacherService.setTeachers(teachers);
        mainView.print("New array was created");
    }

    private void readDataFromFile() {
        try {
            teacherService = new TeacherService();
        } catch (FileNotFoundException e) {
            mainView.printErr("File for reading data not found");
        } catch (IOException e) {
            mainView.printErr("File can not be read ,rewrite file correctly");
        } catch (ClassNotFoundException e) {
            mainView.printErr("Class not found : " + e.getMessage());
        }
    }

}