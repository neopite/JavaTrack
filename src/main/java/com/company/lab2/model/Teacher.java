package com.company.lab2.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Teacher implements Serializable {
    private String name;
    private String surname;
    private String thirdName;
    private String gender;
    private String[] disciplines;
    private String department;
    private String rank;

    public Teacher(String name, String surname, String thirdName, String gender, String[] disciplines, String department, String rank) {
        this.name = name;
        this.surname = surname;
        this.thirdName = thirdName;
        this.gender = gender;
        this.disciplines = disciplines;
        this.department = department;
        this.rank = rank;
    }

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(String[] disciplines) {
        this.disciplines = disciplines;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) &&
                Objects.equals(surname, teacher.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", gender='" + gender + '\'' +
                ", disciplines=" + Arrays.toString(disciplines) +
                ", department='" + department + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
