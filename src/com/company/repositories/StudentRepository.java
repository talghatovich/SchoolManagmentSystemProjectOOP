package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.entities.*;
import com.company.repositories.interfaces.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final IDB db;

    public StudentRepository(IDB db){
        this.db = db;
    }

    public Group getGroupInformation(Student student){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlStatement = "SELECT class_number, class_letter, first_name,last_name " +
                    "FROM classes INNER JOIN teachers ON classes.class_teacher_id=teachers.teacher_id " +
                    "WHERE classes.class_id=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, student.getGroupId());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                Group group = new Group(result.getInt("class_number"), result.getString("class_letter").charAt(0));
                group.getTeacher().setFirstName(result.getString("first_name"));
                group.getTeacher().setLastName(result.getString("last_name"));
                sqlStatement = "SELECT first_name, last_name FROM students WHERE class_id=?";
                statement = con.prepareStatement(sqlStatement);
                statement.setInt(1, student.getGroupId());
                result = statement.executeQuery();
                while(result.next()){
                    group.addStudent(new Student(result.getString("first_name"), result.getString("last_name")));
                }
                return group;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }

    public List<Subject> getSubjectsInformation(Student student){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlStatement = "SELECT subject_id, subject_name, first_name, last_name" +
                    " FROM subjects INNER JOIN teachers ON subjects.teacher_id=teachers.teacher_id WHERE class_id = ?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, student.getGroupId());
            ResultSet result = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(result.next()){
                Subject currentSubject = new Subject();
                currentSubject.setSubjectName(result.getString("subject_name"));
                currentSubject.setTeacherFirstName(result.getString("first_name"));
                currentSubject.setTeacherLastName(result.getString("last_name"));
                sqlStatement = "SELECT day, start_time, end_time " +
                        "FROM schedule INNER JOIN schedule_time " +
                        "ON schedule.schedule_time_id=schedule_time.schedule_time_id WHERE subject_id=?";
                statement = con.prepareStatement(sqlStatement);
                statement.setInt(1, result.getInt("subject_id"));
                ResultSet result2 = statement.executeQuery();
                if(result2.next()) {
                    currentSubject.setDay(result2.getString("day"));
                    currentSubject.setStartTime(result2.getString("start_time"));
                    currentSubject.setEndTime(result2.getString("end_time"));
                    subjects.add(currentSubject);
                }
            }
            return subjects;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }

    public List<Homework> getHomeworkOfSubject(Student student, String subjectName){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlStatement = "SELECT subject_id FROM subjects WHERE class_id=? and subject_name=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, student.getGroupId());
            statement.setString(2, subjectName);
            ResultSet resultSet = statement.executeQuery();
            List<Homework> homeworks = new ArrayList<>();
            while(resultSet.next()){
                sqlStatement = "SELECT deadline, description FROM homeworks WHERE subject_id=?";
                statement = con.prepareStatement(sqlStatement);
                statement.setInt(1, resultSet.getInt("subject_id"));
                ResultSet resultSet2 = statement.executeQuery();
                if(resultSet2.next()){
                    homeworks.add(new Homework(subjectName, resultSet2.getString("deadline"), resultSet2.getString("description")));
                }
            }
            return homeworks;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }

    public List<Lesson> getLessonsInformation(Student student, String subjectName){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlStatement = "SELECT subject_id FROM subjects WHERE class_id=? AND subject_name=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, student.getGroupId());
            statement.setString(2, subjectName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int subjectId = resultSet.getInt("subject_id");
                sqlStatement = "SELECT present, date, mark FROM lessons WHERE subject_id=? and student_id=?";
                statement = con.prepareStatement(sqlStatement);
                statement.setInt(1,subjectId);
                statement.setInt(2, student.getId());
                resultSet = statement.executeQuery();
                List<Lesson> lessons = new ArrayList<>();
                while(resultSet.next()){
                    Lesson lesson = new Lesson(resultSet.getBoolean("present"), resultSet.getString("date"));
                    lesson.setMark(resultSet.getInt("mark"));
                    lessons.add(lesson);
                }
                return lessons;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }
}