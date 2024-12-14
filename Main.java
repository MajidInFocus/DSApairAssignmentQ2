package org.pairedTasks;
/*
TODO List for Main Class
Main Class with ArrayList and Stack Operations
1. Data Fields:
    - ArrayList<Course> courses – Stores all the Course objects.
    - Stack<Course> stack – Separates courses based on faculty codes.
2. Methods:
    - Add a New Course
    - Filter Courses by Faculty Code
    - Display All Courses
    - Display Filtered Courses in Stack
    - Clear the Stack
    - Remove a Course from the courses list by facCode. */

import java.util.*;

public class Main {
    // Data Fields
    private final List<Course> courses = new ArrayList<>();
    private final Stack<Course> stack = new Stack<>();
    // Main Method
    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.run();
    }
    // Run Method
    public void run() {
        // Sample Data
        courses.add(new Course("cs", "Computer Science", 5, 100));
        courses.add(new Course("ac", "Accounting", 3, 80));
        courses.add(new Course("im", "Information Management", 4, 90));

        // Display All Courses
        displayAllCourses();

        // Filter Courses by Faculty Code (User Input)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Faculty Code to filter courses: ");
        String facCode = scanner.nextLine();
        filterCourseByFacCode(facCode);
        // Display Filtered Courses from Stack
        displayStackCourses();

        // Remove Courses by Faculty Code
        System.out.print("Enter Faculty Code to remove courses: ");
        facCode = scanner.nextLine();
        removeCourseByFacCode(facCode);
        // Print selected course to be removed
        displayStackCourses();
        // Display All Courses
        System.out.print("After removing: ");
        displayAllCourses();

        // User inputs to add a New course
        System.out.println("*** Add a New Course ***\n");
        System.out.print("Enter Faculty Code: ");
        String facCode1 = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Number of Lecturers: ");
        int numLec = scanner.nextInt();
        System.out.print("Enter Number of Students: ");
        int numStud = scanner.nextInt();
        // Add a New Course
        addCourse(facCode1, courseName, numLec, numStud);
        System.out.println("New course added successfully.");
        displayAllCourses();

        // Close the scanner
        scanner.close();
        // Clear the stack
        clearStack();
        //Display if the stack is empty
        if (stack.isEmpty()) {
            System.out.println("\nNo Courses to be displayed.\nStack is empty.");
        }
    }
    // Methods
    // Add a new course
    public void addCourse(String facCode, String courseName, int numLec, int numStud) {
        courses.add(new Course(facCode, courseName, numLec, numStud));
    }
    // Filter courses by faculty code and push to stack
    public void filterCourseByFacCode(String facCode) {
        for (Course course : courses) {
            if (course.getFacCode().equalsIgnoreCase(facCode)) {
                stack.push(course);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("No courses found for faculty code: " + facCode);
        }
    }
    // Display all courses
    public void displayAllCourses() {
        System.out.println("*** All Courses ***\n");
        for (Course course : courses) {
            printCourseDetails(course);
        }
    }
    // Display courses in the stack
    public void displayStackCourses() {
        if (stack.isEmpty()) {
            System.out.println("No courses in the stack to display.");
        } else {
            System.out.println("Filtered Courses in Stack:");
            for (Course course : stack) {
                printCourseDetails(course);
            }
        }
    }
    // Clear the stack
    public void clearStack() {
        stack.clear();
        System.out.println("Stack cleared.");
    }
    // Remove courses by faculty code
    public void removeCourseByFacCode(String facCode) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getFacCode().equalsIgnoreCase(facCode)) {
                iterator.remove();
            }
        }
        System.out.println("Removed all courses for faculty code: " + facCode);
    }
    // Helper method to print course details
    private void printCourseDetails(Course course) {
        System.out.println("Faculty Code: " + course.getFacCode());
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Number of Lecturers: " + course.getNumLec());
        System.out.println("Number of Students: " + course.getNumStud());
        System.out.println();
    }
}




