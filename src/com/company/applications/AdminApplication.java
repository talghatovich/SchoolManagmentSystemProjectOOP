package com.company.applications;

import com.company.controllers.AdminController;
import com.company.entities.*;
import com.company.repositories.interfaces.IAdminRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminApplication {

    private final Scanner scanner;
    private final AdminController adminController;

    public AdminApplication(IAdminRepository adminRepository){
        this.adminController = new AdminController(adminRepository);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Start application
     */
    public void run(){
        boolean exit = true;
        while(exit){
            System.out.println("-------Select option: -----------");
            System.out.println("|\t1. Add teacher    \t|");
            System.out.println("|\t2. Delete teacher \t|");
            System.out.println("|\t3. Add student    \t|");
            System.out.println("|\t4. Delete student \t|");
            System.out.println("|\t5. Add class      \t|");
            System.out.println("|\t6. Delete class   \t|");
            System.out.println("|\t7. Add parent     \t|");
            System.out.println("|\t8. Delete parent  \t|");
            System.out.println("|\t9. Log out        \t|");
            System.out.println("|\t0. Exit           \t|");
            System.out.println("--------------------------------");
            System.out.print("| Select option(0-8): ");
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> this.addTeacher();
                    case 2 -> this.deleteTeacher();
                    case 3 -> this.addStudent();
                    case 4 -> this.deleteStudent();
                    case 5 -> this.addClass();
                    case 6 -> this.deleteClass();
                    case 7 -> this.addParent();
                    case 8 -> this.deleteParent();
                    case 9 -> exit = false;
                    case 0 -> System.exit(0);
                    default -> System.out.println("WRONG INPUT");
                }
            } catch (InputMismatchException ex){
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
        }
        System.out.println("Good bye");
    }

    // Method to do not repeat input process
    private User addUser(){
        User user = new User();
        System.out.print("Enter first name: ");
        String string = scanner.next();
        while(!Validator.containOnlyCharacters(string)){
            System.out.println("INVALID INPUT! TRY AGAIN");
            System.out.print("Enter first name: ");
            string = scanner.next();
        }
        user.setFirstName(string);
        System.out.print("Enter last name: ");
        string = scanner.next();
        while(!Validator.containOnlyCharacters(string)){
            System.out.println("INVALID INPUT! TRY AGAIN");
            System.out.print("Enter last name: ");
            string = scanner.next();
        }
        user.setLastName(string);
        System.out.print("Enter gender: ");
        user.setGender(scanner.next().equalsIgnoreCase("male"));
        System.out.print("Enter address: ");
        user.setAddress(scanner.next());
        System.out.print("Enter date of birth(YYYY-MM-DD): ");
        string = scanner.next();
        while(!Validator.checkDate(string)){
            System.out.println("INVALID INPUT! TRY AGAIN");
            System.out.print("Enter date of birth(YYYY-MM-DD): ");
            string = scanner.next();
        }
        user.setDateOfBirth(string);
        System.out.print("Enter email: ");
        string = scanner.next();
        while (!Validator.isEmail(string)){
            System.out.println("INVALID INPUT! TRY AGAIN");
            System.out.print("Enter email: ");
            string = scanner.next();
        }
        user.setEmail(string);
        System.out.print("Enter phone number(XXX-XXX-XXXX): ");
        string = scanner.next();
        while(!Validator.isPhoneNumber(string)){
            System.out.println("INVALID INPUT! TRY AGAIN");
            System.out.print("Enter phone number(XXX-XXX-XXXX): ");
            string = scanner.next();
        }
        user.setPhoneNumber(string);
        return user;
    }

    private void deleteParent() {
        System.out.print("Enter parent id: ");
        System.out.println(adminController.deleteParent(scanner.nextInt()));
    }

    private void addParent() {
        Parent parent = new Parent();
        parent.copy(addUser());
        System.out.println(adminController.addParent(parent));
    }

    private void deleteClass() {
        System.out.print("Enter class id: ");
        System.out.println(adminController.deleteClass(scanner.nextInt()));
    }

    private void addClass() {
        Group group = new Group();
        System.out.print("Enter group number: ");
        group.setGroupNumber(scanner.nextInt());
        System.out.print("Enter group letter: ");
        group.setGroupLetter(scanner.next().charAt(0));
        System.out.print("Enter teacher id: ");
        group.setTeacherId(scanner.nextInt());
        System.out.println(adminController.addClass(group));
    }

    private void deleteStudent() {
        System.out.print("Enter student id: ");
        System.out.println(adminController.deleteStudent(scanner.nextInt()));
    }

    private void addStudent() {
        Student student = new Student();
        student.copy(addUser());
        System.out.print("Enter group id: ");
        student.setGroupId(scanner.nextInt());
        System.out.println(adminController.addStudent(student));
    }

    private void deleteTeacher() {
        System.out.print("Enter teacher id: ");
        System.out.println(adminController.deleteTeacher(scanner.nextInt()));
    }

    private void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.copy(addUser());
        System.out.print("Enter salary: ");
        teacher.setSalary(scanner.nextInt());
        System.out.println(adminController.addTeacher(teacher));
    }
}