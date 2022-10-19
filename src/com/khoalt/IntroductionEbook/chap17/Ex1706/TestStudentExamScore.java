package com.khoalt.IntroductionEbook.chap17.Ex1706;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestStudentExamScore {
    public static void main(String[] args) throws Exception {
        StudentExamScore[] studentScores = new StudentExamScore[5];
        studentScores[0] = new StudentExamScore(1, "Khoa1", 10);
        studentScores[1] = new StudentExamScore(2, "Khoa2", 20);
        studentScores[2] = new StudentExamScore(3, "Khoa3", 30);
        studentScores[3] = new StudentExamScore(4, "Khoa4", 40);
        studentScores[4] = new StudentExamScore(5, "Khoa5", 50);

        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Ex1706.dat"))
        ) {
            for (int i = 0; i < 5; i++) {
                output.writeObject(studentScores[i]);
            }
        }

        try (
             ObjectInputStream input = new ObjectInputStream(new FileInputStream("Ex1706.dat"))
        ) {
            for (int i = 0; i < 5; i++) {
                StudentExamScore obj = (StudentExamScore) input.readObject();
                System.out.println(obj.getId() + " " + obj.getName() + " " + obj.getScore());
            }
        }
    }
}
