package controller;

import controller.validator.Validator;
import exception.InvalidDisciplineFormatException;
import exception.InvalidFormatDepartmentException;
import exception.NumberNotInABoundException;
import model.Teacher;
import model.service.TeacherService;
import org.apache.log4j.Logger;
import util.FileUtil;
import util.TeacherGenerator;
import view.MainView;
import view.RetrievView;
import view.handlerresource.ResourceBundleWords;

import java.io.File;
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
        chooseLang(langChoice);
        initTeacherService();
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
                    logger.fatal("File for writting is not found : "+ TeacherService.getPathFile());
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
                chooseLang(lang);
                break;
            case 8 :
                saveLastQueryToFile();
        }
    }

    private void getAllTeachers() {
        mainView.printTeachers(teacherService.getTeachers());
    }

    private void getTeachersByDepartment() {
        mainView.print(ResourceBundleWords.INPUT_DEPARTMENT);
        String department = retrievView.getArgument();
        logger.info("User enter department name : " + department);
        try {
            Validator.validateInputDepartment(department);
        } catch (InvalidFormatDepartmentException e) {
            logger.error("Bad input format department: " + department);
            mainView.printErr(ResourceBundleWords.INVALID_DEPARTMENT_FORMAT);
            getTeachersByDepartment();
            return;
        }
        Teacher[] executionRes = teacherService.findTeachersByDepartment(department);
        this.teacherService.setLastQueryResult(executionRes);
        mainView.printTeachers(executionRes);
    }

    private void getTeachersByDiscipline() {
        mainView.print(ResourceBundleWords.DISCIPLINE_INPUT);
        String discipline = retrievView.getArgument();
        logger.info("User enter a discipline name : " + discipline);
        try {
            Validator.validateInputDiscipline(discipline);
        } catch (InvalidDisciplineFormatException e) {
            logger.error("Bad input format of discipline : " + discipline);
            mainView.printErr(ResourceBundleWords.INVALID_DISCIPLINE_FORMAT);
            getTeachersByDiscipline();
            return;
        }
        Teacher[] executionResult =teacherService.findTeachersByDiscipline(discipline);
        this.teacherService.setLastQueryResult(executionResult);
        mainView.printTeachers(executionResult);
    }

    private void getWomanAndAssistantProffesor() {
        Teacher[] executionResult =teacherService.findTeachersWomanAndAssistanceProfessor();
        this.teacherService.setLastQueryResult(executionResult);
        mainView.printTeachers(executionResult);
    }

    private void setNewTeachers(Teacher[] teachers) {
        this.teacherService.setTeachers(teachers);
        mainView.print(ResourceBundleWords.TEACHER_ARRAY_CREATED);
    }

    private void initTeacherService() {
        try {
            teacherService = new TeacherService();
        } catch (FileNotFoundException e) {
            logger.fatal("File for reading data not found : "+ TeacherService.getPathFile());
            mainView.printErr(ResourceBundleWords.FILE_FOR_READING_NOT_FOUND);
        } catch (IOException e) {
            logger.fatal("Data from file can not be read : " + TeacherService.getPathFile());
            mainView.printErr(ResourceBundleWords.DATA_CANNOT_BE_READ+ "Файл : " + TeacherService.getPathFile());
        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found : " + e.getMessage());
            mainView.printErr(ResourceBundleWords.CLASS_NOT_FOUND);
        }
    }

    private void chooseLang(String lang) {
        switch (lang) {
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

    private void saveLastQueryToFile(){
        mainView.print(ResourceBundleWords.WHERE_TO_SAVE);
        String path = retrievView.getArgument();
        logger.info("User enter a file path : " + path);
        File file = new File(path);
        if(file.exists()){
            try {
                FileUtil.writeTeachers(this.teacherService.getLastQueryResult(),file.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("Last query result was completely saved in file with path : " + path);
           mainView.print(ResourceBundleWords.COMPLETE_SAVING_FILE);
        }else {
            mainView.printErr(ResourceBundleWords.FILE_FOR_SAVING_NOT_FOUND);
            logger.error("Not right file path for saving results of last query . Path : "+ path);
            saveLastQueryToFile();
        }
    }

}