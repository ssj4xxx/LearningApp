package com.khoalt.IntroductionEbook.Chap17.Ex1706;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ex1707 {
    public static void main(String[] args) throws Exception {
        int count = 0;
        double highestScore = 0;
        int topID = 0;
        String topName = "";
        double totalScore = 0;
        StudentExamScore obj;
        try (
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("Ex1706.dat"))
        ) {

            while (true) {
                obj = (StudentExamScore) input.readObject();
                totalScore = totalScore + obj.getScore();
                count++;
                if (obj.getScore() > highestScore) {
                    highestScore = obj.getScore();
                    topID = obj.getId();
                    topName = obj.getName();
                }
            }
        } catch (EOFException ex) {
            System.out.println("Avg: " + totalScore / count);
            System.out.println("Highest Score: " + highestScore + " ID: " + topID + " Name: " + topName);
        }
    }
}
