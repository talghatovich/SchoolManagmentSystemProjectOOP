package com.company.repositories.interfaces;

import com.company.entities.*;

import java.util.List;

public interface IStudentRepository {

    /**
     * Get information about group (teacher first and last name, class mates and student first and last name)
     * @param student Object of Student class. Important to have groupId field in object!
     * @return Formatted result
     */
    Group getGroupInformation(Student student);

    /**
     * Get information about subject (subject name, teacher first and last name, day, start and end time)
     * @param student Object of Student class. Important to have groupId filed!
     * @return Formatted result
     */
    List<Subject> getSubjectsInformation(Student student);

    /**
     * Get homework of subject by it's name and student information(description, deadline)
     * @param student Object of Student class. Important to know groupId!
     * @param subjectName Name of the subject whose homework you want to know
     * @return Formatted result
     */
    List<Homework> getHomeworkOfSubject(Student student, String subjectName);

    /**
     * Get lesson information(mark, date of lesson, attendance)
     * @param student Object of Student class. Import to know id of student!
     * @param subjectName Name of the subject whose lesson information you want to know
     * @return Formatted result
     */
    List<Lesson> getLessonsInformation(Student student, String subjectName);
}