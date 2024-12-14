package org.pairedTasks;
/*
TODO List for Classes and Methods
Course Class
1. Data Fields (private):
    - Represents the faculty code such as "cs", "ac", "im", etc.
    - Represents the course name.
    - Represents the number of lecturers for the course.
    - Represents the number of students in the course.
2. Methods:
    2.1. Constructor: Initializes all the above attributes.
    2.2. Getters:
        - Returns the faculty code.
        - Returns the course name.
        - Returns the number of lecturers.
        - Returns the number of students.*/
public class Course {
    //Private Data Fields
    private final String facCode, courseName;
    private int numLec, numStud;

    //Constructor
    public Course(String facCode,
                  String courseName,
                  int numLec,
                  int numStud) {
        this.facCode = facCode;
        this.courseName = courseName;
        this.numLec = numLec;
        this.numStud = numStud;
    }

    // *======* Getter methods *======*
    public String getFacCode(){
        return facCode;
    }
    public String getCourseName(){
        return courseName;
    }
    public int getNumLec(){
        return numLec;
    }
    public int getNumStud(){
        return numStud;
    }
}


