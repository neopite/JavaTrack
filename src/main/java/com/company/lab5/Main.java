package com.company.lab5;

import com.company.lab5.controller.TeacherController;
import com.company.lab5.util.FileUtil;
import com.company.lab5.util.TeacherGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       //FileUtil.writeTeachers(TeacherGenerator.generateTeacher(10),"savedData.txt");
        new TeacherController().run();
    }
}
