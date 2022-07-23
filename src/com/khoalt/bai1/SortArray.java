package com.khoalt.bai1;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    static Scanner input = new Scanner(System.in);
    static int[] numberList = new int[10];

    public static void main(String[] args) {
        System.out.print("Nhap 10 so tu nhien: ");
        for (int i = 0; i < 10; i++) {
            numberList[i] = input.nextInt();
        }
        int temp = 0;
        int startIndex = 0;
        while (startIndex < 10) {
            for (int i = startIndex; i < 10; i++) {
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
}
