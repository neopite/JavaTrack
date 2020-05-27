package com.company.lab3;

import com.company.lab3.controller.TeacherController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // FileUtil.writeTeachers(TeacherGenerator.generateTeacher(10),"savedData.txt");
        new TeacherController().run();
    }
}
