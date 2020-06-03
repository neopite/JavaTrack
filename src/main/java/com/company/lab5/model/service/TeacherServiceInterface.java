package com.company.lab5.model.service;

import com.company.lab5.model.Teacher;

public interface TeacherServiceInterface {
    Teacher[] findTeachersByDepartment(String department);
    Teacher[] findTeachersByDiscipline(String discipline);
    Teacher[] findTeachersWomanAndAssistanceProfessor();
}
