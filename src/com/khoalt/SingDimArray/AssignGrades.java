package com.khoalt.SingDimArray;

import java.util.Scanner;

public class AssignGrades {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of students: ");
        int number = input.nextInt();
        int[] grades = new int[number];
        System.out.print("Enter " + number + " scores: ");
        for (int i = 0; i < number; i++) {
            grades[i] = input.nextInt();
        }
        printResult(grades);
    }

    static void printResult(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Student " + i + " score is " + grades[i] + " and grade is " + ranking(grades, grades[i]));
        }
    }

    static int getBestStudent(int[] grades) {
        int bestStudent = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[bestStudent] < grades[i]) {
                bestStudent = i;
            }
        }
        return bestStudent;
    }

    static String ranking(int[] grades, int grade) {
        int bestStudent = getBestStudent(grades);
        int diff = grades[bestStudent] - grade;
        if (diff <= 5) {
            return "A";
        } else if (diff <= 10) {
            return "B";
        } else if (diff <= 15) {
            return "C";
        } else if (diff <= 20) {
            return "D";
        } else {
            return "F";
        }
    }
}
