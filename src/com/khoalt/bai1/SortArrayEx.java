package com.khoalt.bai1;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayEx {
    static Scanner input = new Scanner(System.in);
    static int[] numberList = new int[1000];

    public static void main(String[] args) {
        System.out.print("Numbers: ");
        createNumberList(0, 1000);
        sortArray(numberList);
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
