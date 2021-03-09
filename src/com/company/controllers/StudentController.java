package com.company.controllers;

import com.company.entities.*;
import com.company.repositories.interfaces.IStudentRepository;

import java.util.Formatter;
import java.util.List;

public class StudentController {
    private final IStudentRepository studentRepository;

    public StudentController(IStudentRepository studentRepository) { this.studentRepository = studentRepository;}

    /**
     * Get information about group (teacher first and last name, class mates and student first and last name)
     * @param student Object of Student class. Important to have groupId field in object!
     * @return Formatted result
     */
    public Formatter getGroupInformation(Student student){
        Group group = studentRepository.getGroupInformation(student);
        Formatter formatter = new Formatter();
        formatter.format("=====================================================");
        formatter.format("\n%15s\t%15s\n", "First name", "Last name");
        formatter.format("=====================================================\n%15s:\n", "Teacher");
        formatter.format("%15s\t%15s\n", group.getTeacherFirstName(), group.getTeacherLastName());
        formatter.format("=====================================================\n%15s:\n", "Class mates");
        for(Student _student : group.getStudentList()){
            formatter.format("%15s\t%15s\n", _student.getFirstName(), _student.getLastName());
        }
        formatter.format("=====================================================\n");
        return formatter;
    }

    /**
     * Get information about subject (subject name, teacher first and last name, day, start and end time)
     * @param student Object of Student class. Important to have groupId filed!
     * @return Formatted result
     */
    public Formatter getSubjectsInfo(Student student){
        List<Subject> subjects = studentRepository.getSubjectsInformation(student);
        Formatter formatter = new Formatter();
        formatter.format("===============================================================================================\n");
        formatter.format("%15s\t%20s\t%15s\t%15s\t%15s\n", "Subject name", "Teacher", "Day", "Start time", "End time");
        formatter.format("===============================================================================================\n");
        for(Subject subject: subjects){
            formatter.format("%15s\t%20s\t%15s\t%15s\t%15s\n", subject.getSubjectName(), subject.getTeacherFirstName() + " " + subject.getTeacherLastName(), subject.getDay(), subject.getStartTime(), subject.getEndTime());
        }
        formatter.format("===============================================================================================\n");
        return formatter;
    }

    /**
     * Get homework of subject by it's name and student information(description, deadline)
     * @param student Object of Student class. Important to know groupId!
     * @param subjectName Name of the subject whose homework you want to know
     * @return Formatted result
     */
    public Formatter getHomeworkOfSubject(Student student, String subjectName){
        List<Homework> homeworks = studentRepository.getHomeworkOfSubject(student, subjectName);
        Formatter formatter = new Formatter();
        formatter.format("==================================================================================================\n");
        formatter.format("%80s\t%12s\n", "Description", "Deadline");
        formatter.format("==================================================================================================\n");
        for(Homework homework : homeworks){
            formatter.format("%80s\t%12s\n", homework.getDescription(), homework.getDeadline());
        }
        formatter.format("==================================================================================================\n");
        return formatter;
    }

    /**
     * Get lesson information(mark, date of lesson, attendance)
     * @param student Object of Student class. Import to know id of student!
     * @param subjectName Name of the subject whose lesson information you want to know
     * @return Formatted result
     */
    public Formatter getLessonsInformation(Student student, String subjectName){
        List<Lesson> lessons = studentRepository.getLessonsInformation(student, subjectName);
        Formatter formatter = new Formatter();
        formatter.format("====================================\n");
        formatter.format("%12s\t%10s\t%5s\n", "Date", "Present", "Mark");
        formatter.format("====================================\n");
        for(Lesson lesson: lessons) {
            formatter.format("%12s\t%10s\t%5s\n", lesson.getDate(), lesson.isPresent(), lesson.getMark());
        }
        formatter.format("====================================\n");
        return formatter;
    }
}