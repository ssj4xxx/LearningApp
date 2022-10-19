package com.khoalt.IntroductionEbook.chap10.Ex109;

public class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public void addStudent(String student) {
        int courseSlot = students.length;
        if (this.numberOfStudents == courseSlot) {
            String[] largerStudentPool = new String[courseSlot + 1];
            System.arraycopy(students, 0, largerStudentPool, 0, numberOfStudents - 1);
            this.students = largerStudentPool;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }
    public String[] getStudents() {
        String[] studentsInCourse = new String[numberOfStudents];
        System.arraycopy(students, 0, studentsInCourse, 0, numberOfStudents - 1);
        return studentsInCourse;
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public String getCourseName() {
        return courseName;
    }
    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i] == student) {
                String[] newList = new String[numberOfStudents - 1];
                System.arraycopy(students,0, newList, 0, i);
                System.arraycopy(students, i + 1, newList, i, numberOfStudents - i - 1);
                students = newList;
                numberOfStudents--;
                break;
            }
        }
    }

    public void clear() {
        String[] newStudentInCourse = new String[numberOfStudents];
        students = newStudentInCourse;
        numberOfStudents = 0;
    }
}