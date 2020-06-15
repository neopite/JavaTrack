package model.service;


import model.Teacher;
import util.FileUtil;

import java.io.IOException;

public class TeacherService implements TeacherServiceInterface {

    private Teacher[] teachers;
    private static final String PATH_FILE = "savedData.txt";
    private Teacher[] lastQueryResult;

    public TeacherService() throws IOException, ClassNotFoundException {
        this.teachers = FileUtil.readTeachers(PATH_FILE);
    }

    public void writeDataToFile() throws IOException {
        FileUtil.writeTeachers(this.getTeachers(), PATH_FILE);
    }

    @Override
    public Teacher[] findTeachersByDepartment(String department) {
        Teacher[] teachersByDepartment = new Teacher[teachers.length];
        int counter = 0;
        for (int itter = 0; itter < teachersByDepartment.length; itter++) {
            if (teachers[itter].getDepartment().equals(department)) {
                teachersByDepartment[counter] = teachers[itter];
                counter++;
            }
        }
        return arrayWithoutNulls(teachersByDepartment, counter);
    }

    @Override
    public Teacher[] findTeachersByDiscipline(String discipline) {
        Teacher[] teachersByDisciplines = new Teacher[this.teachers.length];
        int counter = 0;
        for (int itter = 0; itter < teachersByDisciplines.length; itter++) {
            if (isContainsDiscipline(discipline, this.teachers[itter].getDisciplines())) {
                teachersByDisciplines[counter] = this.teachers[itter];
                counter++;
            }
        }
        return arrayWithoutNulls(teachersByDisciplines, counter);
    }

    @Override
    public Teacher[] findTeachersWomanAndAssistanceProfessor() {
        Teacher[] teachers = new Teacher[this.teachers.length];
        int counter = 0;
        for (int itter = 0; itter < teachers.length; itter++) {
            if (this.teachers[itter].getGender().equals("Woman") && this.teachers[itter].getRank().equals("Assistant professor")) {
                teachers[counter] = this.teachers[itter];
                counter++;
            }
        }
        return arrayWithoutNulls(teachers, counter);
    }

    private Teacher[] arrayWithoutNulls(Teacher[] arrayWithNulls, int length) {
        Teacher[] arrayWithoutNulls = new Teacher[length];
        int counter = 0;
        for (Teacher arrayWithNull : arrayWithNulls) {
            if (arrayWithNull == null) {
                continue;
            } else {
                arrayWithoutNulls[counter] = arrayWithNull;
                counter++;
            }
        }
        return arrayWithoutNulls;
    }

    private boolean isContainsDiscipline(String discipline, String[] teachersDisciplines) {
        for (String teachersDiscipline : teachersDisciplines) {
            if (teachersDiscipline.equals(discipline)) {
                return true;
            }
        }
        return false;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public static String getPathFile() {
        return PATH_FILE;
    }

    public Teacher[] getLastQueryResult() {
        return lastQueryResult;
    }

    public void setLastQueryResult(Teacher[] lastQueryResult) {
        this.lastQueryResult = lastQueryResult;
    }
}
