package com.company.lab2.controller;


import com.company.lab2.exception.InvalidDisciplineFormatException;
import com.company.lab2.exception.InvalidFormatDepartmentException;
import com.company.lab2.exception.NumberNotInABoundException;
import com.company.lab2.model.Teacher;
import com.company.lab2.service.TeacherService;
import com.company.lab2.util.TeacherGenerator;
import com.company.lab2.validator.Validator;
import com.company.lab2.view.MainView;
import com.company.lab2.view.RetrievView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.company.lab3.view.MainView.printMenu;

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
        teacherService = new TeacherService();
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

}