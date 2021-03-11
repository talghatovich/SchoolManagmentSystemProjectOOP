package com.company.controllers;

import com.company.database.interfaces.IDB;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.repositories.UserRepository;

// Class to log in

public class UserController {
    private final UserRepository repository;
    public UserController(UserRepository repository){
        this.repository = repository;
    }

    /**
     * Method to get link to data base
     * @return link to data base object
     */
    public IDB getDataBase(){
        return repository.getDb();
    }

    /**
     * Method to log in as student
     * @param login Login of student account
     * @param password Password of account
     * @return Object of student with personal information if login and password are correct. Otherwise return null
     */
    public Student loginStudent(String login, String password){
        return repository.loginStudent(login, password);
    }

    /**
     * Mathod to log in as parent
     * @param login Login of parent account
     * @param password Password of account
     * @return Object of parent with personal information if login and password are correct. Otherwise return null
     */
    public Parent loginParent(String login, String password){
        return repository.loginParent(login, password);
    }

}
