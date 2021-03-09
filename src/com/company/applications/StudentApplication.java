package com.company.applications;

import com.company.controllers.StudentController;
import com.company.entities.Student;
import com.company.repositories.interfaces.IStudentRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentApplication {

    //It is all protected because it is reused in ParentApplication

    protected final StudentController studentController;
    protected Scanner scanner;
    protected final Student student;

    public StudentApplication(IStudentRepository studentRepository, Student student){
        this.studentController =  new StudentController(studentRepository);
        this.student = student;
        scanner = new Scanner(System.in);
    }

    /**
     * Method to start application
     */
    public void run() {
        System.out.println("Welcome " + student.getFirstName() + " " + student.getLastName());
        boolean exit = true;
        while (exit) {
            System.out.println("---------Select option: --------");
            System.out.println("|\t1. Get my information       |");
            System.out.println("|\t2. Get schedule             |");
            System.out.println("|\t3. Get marks of subject     |");
            System.out.println("|\t4. Get homework of subject  |");
            System.out.println("|\t5. Log out                  |");
            System.out.println("|\t0. Exit                     |");
            System.out.println("--------------------------------");
            System.out.print("| Select option(0-4): ");
            try {
                switch (scanner.nextInt()) {
                    case 1 -> this.getInformation();
                    case 2 -> this.getSubjectsInfo();
                    case 3 -> this.getMarkOfSubject();
                    case 4 -> this.getHomeworkOfSubject();
                    case 5 -> exit = false;
                    case 0 -> System.exit(0);
                    default -> System.out.println("WRONG INPUT"); // If there is no option with this number
                }
            } catch (InputMismatchException ex){
                System.out.println("Input must be integer"); // If input is not integer
                scanner.nextLine(); // to ignore incorrect input
            }
        }
        System.out.println("Good bye " + student.getFirstName() + " " + student.getLastName());
    }

    protected void getHomeworkOfSubject() {
        System.out.print("Enter subject name: ");
        System.out.println(studentController.getHomeworkOfSubject(student, scanner.next()));
    }

    protected void getMarkOfSubject() {
        System.out.print("Enter subject name: ");
        System.out.println(studentController.getLessonsInformation(student, scanner.next()));
    }

    protected void getSubjectsInfo() {
        System.out.println(studentController.getSubjectsInfo(student));
    }

    protected void getInformation() {
        System.out.print(studentController.getGroupInformation(this.student));
    }
}
