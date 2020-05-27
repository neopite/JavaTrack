package com.company.neophite.service;

import com.company.neophite.model.Teacher;

public interface TeacherServiceInterface {
    Teacher[] findTeachersByDepartment(String department);
    Teacher[] findTeachersByDiscipline(String discipline);
    Teacher[] findTeachersWomanAndAssistanceProfessor();
}
