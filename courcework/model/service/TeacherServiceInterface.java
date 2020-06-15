package model.service;

import model.Teacher;

public interface TeacherServiceInterface {
    Teacher[] findTeachersByDepartment(String department);
    Teacher[] findTeachersByDiscipline(String discipline);
    Teacher[] findTeachersWomanAndAssistanceProfessor();
}
