package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.repositories.interfaces.IParentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentRepository implements IParentRepository {
    private final IDB db;

    public ParentRepository(IDB db) {
        this.db = db;
    }

    public Student getChild(Parent parent){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlStatement = "SELECT student_id FROM student_parent WHERE parent_id=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, parent.getId());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                sqlStatement = "SELECT student_id, first_name, last_name, gender, address, date_of_birth, class_id, email, phone, password " +
                        "FROM students WHERE student_id=?";
                statement = con.prepareStatement(sqlStatement);
                statement.setInt(1, resultSet.getInt("student_id"));
                resultSet = statement.executeQuery();
                if(resultSet.next()){
                    Student student = new Student(resultSet.getInt("student_id"), resultSet.getString("first_name"),
                            resultSet.getString("last_name"), resultSet.getBoolean("gender"),
                            resultSet.getString("address"), resultSet.getString("date_of_birth"),
                            resultSet.getString("email"), resultSet.getString("phone"),
                            resultSet.getInt("class_id"));
                    if(resultSet.getString("email") != null) student.setEmail(resultSet.getString("email"));
                    if(resultSet.getString("phone") != null) student.setPhoneNumber(resultSet.getString("phone"));
                    return student;
                }
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
