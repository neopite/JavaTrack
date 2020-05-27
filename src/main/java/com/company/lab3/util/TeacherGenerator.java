package com.company.lab3.util;

import com.company.lab3.model.Teacher;

import java.util.Arrays;
import java.util.List;

public class TeacherGenerator {
    private static final List<String> MALE_TEACHERS_NAMES = Arrays.asList("Stanislav", "Bogdan", "Petro", "Ivan");
    private static final List<String> FEMALE_TEACHERS_NAMES = Arrays.asList("Yana", "Marya", "Kate", "Julia");
    private static final String[] SURNAMES = {
            "Oleschenko", "Stetcenko", "Kolesnik", "Knish"
    };
    private static final String[] MALE_TEACHERS_THIRDNAME = {
            "Yaroslavovich", "Bogdanovich", "Petrovich", "Vladimirovich"
    };
    private static final String[] FEMALE_TEACHERS_THIRDNAME = {
            "Yaroslavivna", "Bogdanivna", "Petrivna", "Vladimirovna"
    };
    private static final String[] GENDER = {
            "Man", "Woman"
    };

    private static final String[] DISCIPLINES = {
            "Math", "Physic", "Chemistry", "English", "Deutch", "KPI", "Programming"
    };

    private static final String[] DEPARTMENT = {
            "ASOIU", "VT", "AUTS", "TK"
    };

    private static final String[] RANK = {
            "Assistant professor", "Professor", "Teacher", "Senior Teacheer"
    };

    public static Teacher[] generateTeacher(int count) {
        Teacher[] teachers = new Teacher[count];
        for (int itter = 0; itter < count; itter++) {
            String name = generetaName();
            teachers[itter]=new Teacher(name,generetaSurname(),generateThirdName(name),getGender(name),generateDiscpiplines(),generateDepartment(),generateRank());
        }
        return teachers;
    }

    private static String generetaName() {
        int choose = (int) (Math.random() * 2);
        if (choose == 0) {
            return MALE_TEACHERS_NAMES.get((int) (Math.random() * 4));
        } else if (choose == 1) {
            return FEMALE_TEACHERS_NAMES.get((int) (Math.random() * 4));
        }
        return "";
    }

    private static String generetaSurname() {
        return SURNAMES[(int)(Math.random()*3 + 1)];
    }

    private static String generateThirdName(String name) {
        if (MALE_TEACHERS_NAMES.contains(name)) {
            return MALE_TEACHERS_THIRDNAME[(int) (Math.random() *4)];
        } else if (FEMALE_TEACHERS_NAMES.contains(name)) {
            return FEMALE_TEACHERS_THIRDNAME[(int) (Math.random() * 4)];
        }
        return "";
    }
    private static String getGender(String name){
        if(FEMALE_TEACHERS_NAMES.contains(name)){
            return GENDER[1];
        }else if(MALE_TEACHERS_NAMES.contains(name)){
            return GENDER[0];
        }
        return "";
    }
    private static String [] generateDiscpiplines(){
        String [] disciplines = new String [(int)(Math.random()*3 + 1)];
        for (int itter = 0; itter < disciplines.length; itter++) {
            disciplines[itter]=DISCIPLINES[(int)(Math.random()*7)];
        }
        return disciplines;
    }
    private static String generateDepartment(){
        return DEPARTMENT[(int)(Math.random()*4)];
    }
    private static String generateRank(){
        return RANK[(int)(Math.random()*4)];
    }

    public static List<String> getMaleTeachersNames() {
        return MALE_TEACHERS_NAMES;
    }

    public static List<String> getFemaleTeachersNames() {
        return FEMALE_TEACHERS_NAMES;
    }

    public static String[] getSURNAMES() {
        return SURNAMES;
    }

    public static String[] getMaleTeachersThirdname() {
        return MALE_TEACHERS_THIRDNAME;
    }

    public static String[] getFemaleTeachersThirdname() {
        return FEMALE_TEACHERS_THIRDNAME;
    }

    public static String[] getGENDER() {
        return GENDER;
    }

    public static String[] getDISCIPLINES() {
        return DISCIPLINES;
    }

    public static String[] getDEPARTMENT() {
        return DEPARTMENT;
    }

    public static String[] getRANK() {
        return RANK;
    }
}


