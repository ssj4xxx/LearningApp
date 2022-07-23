package com.khoalt.IntroductionChap9.Ex96;

import java.util.Arrays;
import java.util.Scanner;

import static com.khoalt.IntroductionChap9.Ex96.StopWatch.*;

public class TestStopWatch {

    StopWatch sortingStopWatch = new StopWatch();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        System.out.println("Press Enter to start");
//        input.nextLine();
        createNumberList(0, 1000);
        start();
        sortArray(numberList);
        end();
        System.out.println("");
//        System.out.println("Press Enter to end");
//        input.nextLine();
        System.out.println(getElapsedTime() + " miliseconds");
        input.nextLine();
    }

    public static void sortArray(int[] numberList) {
        int temp = 0;
        int startIndex = 0;
        while (startIndex < 1000) {
            for (int i = startIndex; i < 1000; i++) {
                int min = numberList[startIndex];
                if (min >= numberList[i]) {
                    min = numberList[i];
                    temp = numberList[startIndex];
                    numberList[startIndex] = numberList[i];
                    numberList[i] = temp;
                }
            }
            startIndex++;
        }
        System.out.print(Arrays.toString(numberList));
    }

    public static void createNumberList(int min, int max) {
        for (int i = 0; i < 1000; i++) {
            numberList[i] = min + (int)(Math.random() * max);
        }
    }
}
