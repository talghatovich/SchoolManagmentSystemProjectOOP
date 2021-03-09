package com.company.applications;

import com.company.controllers.UserController;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.repositories.AdminRepository;
import com.company.repositories.StudentRepository;
import com.company.repositories.UserRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    This is main application class. In this class we decide how to log in. It is important to know login and password
    Login format: FirstName_LastName_ID
    You can use this:
    Studnet
    Login: Ad_McGorman_1
    Password: 123
    Parent
    Login: Lauryn_Vikky_1
    Password: 123
 */

public class Application {
    private final UserController controller;
    private final Scanner scanner;

    public Application(UserRepository repository){
        this.controller = new UserController(repository);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method to start application
     */
    public void run(){
        boolean exit = false;
        while(!exit) {
            System.out.println("===Log in like===");
            System.out.println("|\t1. Student\t|");
            System.out.println("|\t2. Parent \t|");
            System.out.println("|\t3. Admin  \t|");
            System.out.println("|\t0. Exit   \t|");
            System.out.print("Enter option(0-3): ");
            try {
                int option = scanner.nextInt();
                switch (option) {
                    // Log in as student
                    case 1 -> {
                        System.out.print("Enter login: ");
                        String login = scanner.next();
                        System.out.print("Enter password: ");
                        String password = scanner.next();
                        // Trying to log in
                        Student student = this.controller.loginStudent(login, password);
                        // Logged in successfully
                        if (student != null) {
                            StudentApplication studentApplication = new StudentApplication(new StudentRepository(this.controller.getDataBase()), student);
                            studentApplication.run();
                        } else { // Otherwise
                            System.out.println("Permission denied");
                        }
                    }
                    // Login as parent
                    case 2 -> {
                        System.out.print("Enter login: ");
                        String login = scanner.next();
                        System.out.print("Enter password: ");
                        String password = scanner.next();
                        // Trying to log in
                        Parent parent = this.controller.loginParent(login, password);
                        // Logged in successfully
                        if (parent != null) {
                            ParentApplication parentApplication = new ParentApplication(this.controller.getDataBase(), parent);
                            parentApplication.run();
                        } else { // Otherwise
                            System.out.println("Permission denied");
                        }
                    }
                    // Login as admin
                    case 3 -> {
                        System.out.print("Enter login: ");
                        String login = scanner.next();
                        System.out.print("Enter password: ");
                        String password = scanner.next();
                        // Logged in successfully
                        if (login.equals("admin") && password.equals("Qwerty123!")) {
                            AdminApplication adminApplication = new AdminApplication(new AdminRepository(this.controller.getDataBase()));
                            adminApplication.run();
                        } else { // Otherwise
                            System.out.println("Permission denied");
                        }
                    }
                    case 0 -> exit = true;
                    default -> System.out.println("WRONG INPUT!"); // If there is no option with this number
                }
            } catch (InputMismatchException ex) {
                System.out.println("Input must be integer"); // If input is not integer
                scanner.nextLine();
            }
        }
    }
}
