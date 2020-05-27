package com.company.lab5.util;

import com.company.lab5.model.Teacher;

import java.io.*;

public class FileUtil {


    public static void writeTeachers(Teacher[] teachers, String filePath) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(teachers);

    }


    public static Teacher[] readTeachers(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        Teacher[] teachers = (Teacher[]) objectInputStream.readObject();
        return teachers;
    }


}