package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository{
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    public IDB getDb() {
        return db;
    }

    private String[] parseLogin(String login){
        return login.split("_");
    }

    public Student loginStudent(String login, String password){
        String[] loginParams = parseLogin(login);
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlStatement = "SELECT student_id, first_name, last_name, gender, address, date_of_birth, class_id, email, phone, password " +
                    "FROM students WHERE student_id=? AND first_name=? AND last_name=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, Integer.parseInt(loginParams[2]));
            statement.setString(2, loginParams[0]);
            statement.setString(3, loginParams[1]);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                if(!resultSet.getString("password").equals(password)){
                    return null;
                }
                Student student = new Student(resultSet.getInt("student_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getBoolean("gender"),
                        resultSet.getString("address"), resultSet.getString("date_of_birth"),
                        resultSet.getString("email"), resultSet.getString("phone"),
                        resultSet.getInt("class_id"));
                if(resultSet.getString("email") != null) student.setEmail(resultSet.getString("email"));
                if(resultSet.getString("phone") != null) student.setPhoneNumber(resultSet.getString("phone"));
                return student;
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

    public Parent loginParent(String login, String password){
        String[] loginParams = parseLogin(login);
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlStatement = "SELECT parent_id, first_name, last_name, gender, address, date_of_birth, email, phone, password " +
                    "FROM parents WHERE first_name=? AND last_name=? AND parent_id=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setString(1, loginParams[0]);
            statement.setString(2, loginParams[1]);
            statement.setInt(3, Integer.parseInt(loginParams[2]));
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                if(!resultSet.getString("password").equals(password)) return null;
                return new Parent(resultSet.getInt("parent_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getBoolean("gender"),
                        resultSet.getString("address"), resultSet.getString("date_of_birth"),
                        resultSet.getString("email"), resultSet.getString("phone"));
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
