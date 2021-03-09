package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.entities.*;
import com.company.entities.Group;
import com.company.repositories.interfaces.IAdminRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepository implements IAdminRepository {
    private final IDB db;

    public AdminRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "INSERT INTO Teachers(first_name, last_name, gender, " +
                    "address, date_of_birth, email, phone, salary,password ) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, teacher.getFirstName());
            st.setString(2, teacher.getLastName());
            st.setBoolean(3,teacher.getGender());
            st.setString(4, teacher.getAddress());
            st.setString(5, teacher.getDateOfBirth());
            st.setString(6, teacher.getEmail());
            st.setString(7, teacher.getPhoneNumber());
            st.setInt(8, teacher.getSalary());
            st.setString(9, "123");

            return st.execute();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean deleteTeacher(int id) {
        Connection con = null;
        try {
            con= db.getConnection();
            String sql = "DELETE FROM Teachers " +
                    "WHERE teacher_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            return st.execute();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean addStudent(Student student) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Students(first_name, last_name, gender, " +
                    "address, date_of_birth, email, phone, class_id ,password ) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, student.getFirstName());
            st.setString(2, student.getLastName());
            st.setBoolean(3,student.getGender());
            st.setString(4, student.getAddress());
            st.setString(5, student.getDateOfBirth());
            st.setString(6, student.getEmail());
            st.setString(7, student.getPhoneNumber());
            st.setInt(8, student.getGroupId());
            st.setString(9, "123");

            return st.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean deleteStudent(int id) {
        Connection con = null;
        try {
            con= db.getConnection();
            String sql = "DELETE FROM Students " +
                    "WHERE student_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            return st.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean addClass(Group group) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Classes(class_teacher_id, class_number, class_letter) VALUES(?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, group.getTeacher().getId());
            st.setInt(2, group.getGroupNumber());
            st.setString(3, String.valueOf(group.getGroupLetter()));
            return st.execute();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean deleteClass(int id) {
        Connection con = null;
        try {
            con= db.getConnection();
            String sql = "DELETE FROM Classes " +
                    "WHERE class_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            return st.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean addParent(Parent parent) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Parents(first_name, last_name, gender, address, date_of_birth, email, phone, password)" +
                    "VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, parent.getFirstName());
            st.setString(2, parent.getLastName());
            st.setBoolean(3, parent.getGender());
            st.setString(4, parent.getAddress());
            st.setString(5, parent.getDateOfBirth());
            st.setString(6, parent.getEmail());
            st.setString(7, parent.getPhoneNumber());
            st.setString(8, "123");

            return st.execute();


        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean deleteParent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "DELETE FROM parents " +
                    "WHERE parent_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            return st.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    public String[] getStudentLoginAndPassword(Student student){
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "SELECT student_id, password FROM students WHERE first_name=? and last_name=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();
            String[] result = new String[2];
            if(resultSet.next()){
                result[0] = student.getFirstName() + "_" + student.getLastName() + "_" + resultSet.getInt("student_id");
                result[1] = resultSet.getString("password");
                return result;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }

    public String[] getParentLoginAndPassword(Parent parent){
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "SELECT parent_id, password FROM parent WHERE first_name=? and last_name=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, parent.getFirstName());
            preparedStatement.setString(2, parent.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();
            String[] result = new String[2];
            if(resultSet.next()){
                result[0] = parent.getFirstName() + "_" + parent.getLastName() + "_" + resultSet.getInt("parent_id");
                result[1] = resultSet.getString("password");
                return result;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }

}
