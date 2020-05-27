package com.company.lab5.controller;

import com.company.lab5.exception.InvalidDisciplineFormatException;
import com.company.lab5.exception.InvalidFormatDepartmentException;
import com.company.lab5.exception.NumberNotInABoundException;
import com.company.lab5.model.Teacher;
import com.company.lab5.service.TeacherService;
import com.company.lab5.handlerresource.ResourceBundleWords;
import com.company.lab5.util.TeacherGenerator;
import com.company.lab5.validator.Validator;
import com.company.lab5.view.MainView;
import com.company.lab5.view.RetrievView;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class TeacherController {

    private static final int EXIT_CODE = 5;

    private TeacherService teacherService;
    private MainView mainView;
    private RetrievView retrievView;
    private static Logger logger = Logger.getLogger(TeacherController.class.getName());

    public TeacherController() {
        mainView = new MainView();
        retrievView = new RetrievView();
    }

    public void run() {
        logger.info("The app have started ...");
        mainView.print(ResourceBundleWords.LANG_MENU);
        String langChoice = retrievView.getArgument();
        languageChoice(langChoice);
        readDataFromFile();
        if (this.teacherService == null) return;
        while (true) {
            mainView.print(ResourceBundleWords.MAIN_MENU);
            String data = retrievView.getNumberOfFuction();
            try {
                Validator.validateChoosingNumberOfMenu(data);
            } catch (NumberFormatException | NumberNotInABoundException e) {
                logger.error("User enter error number format : " + data);
                mainView.printErr(ResourceBundleWords.INVALID_FORMAT_INPUT_NUMBER);
                continue;
            }
            if (Integer.parseInt(data) == EXIT_CODE) {
                try {
                    teacherService.writeDataToFile();
                } catch (FileNotFoundException e) {
                    logger.fatal("File for writting is not found");
                    mainView.printErr(ResourceBundleWords.FILE_FOR_WRITING_NOT_FOUND);
                } catch (IOException e) {
                    logger.fatal("Data for writting in file can not be write");
                    mainView.printErr(ResourceBundleWords.FILE_WRITING_EXCEPTION);
                }
                mainView.print(ResourceBundleWords.EXIT);
                logger.info("File is saved , exit from program");
                return;
            }
            actions(Integer.parseInt(data));
        }
    }

    private void actions(int action) {
        logger.debug("User enter : " + action);
        switch (action) {
            case 1:
                getAllTeachers();
                logger.debug("User get all teachers list");
                break;
            case 2:
                getTeachersByDepartment();
                logger.debug("User get all teachers list by department");
                break;
            case 3:
                getTeachersByDiscipline();
                logger.debug("User get all teachers list by discipline list");
                break;
            case 4:
                getWomanAndAssistantProffesor();
                logger.debug("User get all teachers list of womans assistant proffesor list");
                break;
            case 6:
                setNewTeachers(TeacherGenerator.generateTeacher(10));
                logger.info("User set new teachers list");
                break;
            case 7 :
                mainView.print(ResourceBundleWords.LANG_MENU);
                String lang = retrievView.getArgument();
                languageChoice(lang);
                break;
        }
    }

    private void getAllTeachers() {
        mainView.printTeachers(teacherService.getTeachers());
    }

    private void getTeachersByDepartment() {
        mainView.print(ResourceBundleWords.INPUT_DEPARTMENT);
        String department = retrievView.getArgument();
        try {
            Validator.validateInputDepartment(department);
        } catch (InvalidFormatDepartmentException e) {
            logger.error("Bad input format department: " + department);
            mainView.printErr(ResourceBundleWords.INVALID_DEPARTMENT_FORMAT);
            getTeachersByDepartment();
        }
        mainView.printTeachers(teacherService.findTeachersByDepartment(department));
    }

    private void getTeachersByDiscipline() {
        mainView.print(ResourceBundleWords.DISCIPLINE_INPUT);
        String discipline = retrievView.getArgument();
        try {
            Validator.validateInputDiscipline(discipline);
        } catch (InvalidDisciplineFormatException e) {
            logger.error("Bad input format of discipline : " + discipline);
            mainView.printErr(ResourceBundleWords.INVALID_DISCIPLINE_FORMAT);
            getTeachersByDiscipline();
        }
        mainView.printTeachers(teacherService.findTeachersByDiscipline(discipline));
    }

    private void getWomanAndAssistantProffesor() {
        mainView.printTeachers(teacherService.findTeachersWomanAndAssistanceProfessor());
    }

    private void setNewTeachers(Teacher[] teachers) {
        this.teacherService.setTeachers(teachers);
        mainView.print(ResourceBundleWords.TEACHER_ARRAY_CREATED);
    }

    private void readDataFromFile() {
        try {
            teacherService = new TeacherService();
        } catch (FileNotFoundException e) {
            logger.fatal("File for reading data not found");
            mainView.printErr(ResourceBundleWords.FILE_FOR_READING_NOT_FOUND);
        } catch (IOException e) {
            logger.fatal("File for reading data not found");
            mainView.printErr(ResourceBundleWords.FILE_FOR_READING_NOT_FOUND);
        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found : " + e.getMessage());
            mainView.printErr(ResourceBundleWords.CLASS_NOT_FOUND);
        }
    }

    private void languageChoice(String langChoice) {
        switch (langChoice) {
            case "2":
                mainView.setLocaleAndRes(new Locale("ru", "RU"));
                logger.info("User change interface language on RUS");
                break;
            case "3":
                mainView.setLocaleAndRes(new Locale("uk", "UA"));
                logger.info("User change interface language on UK");
                break;
            default:
                mainView.setLocaleAndRes(new Locale("en", "GB"));
                logger.info("User change interface language on ENG");
        }
    }

}