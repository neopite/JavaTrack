package com.company.lab1.service;

import com.company.lab1.model.Teacher;

public interface TeacherServiceInterface {
    Teacher[] findTeachersByDepartment(String department);
    Teacher[] findTeachersByDiscipline(String discipline);
    Teacher[] findTeachersWomanAndAssistanceProfessor();
}
