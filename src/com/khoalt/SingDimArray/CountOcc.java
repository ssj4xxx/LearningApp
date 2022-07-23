package com.khoalt.SingDimArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CountOcc {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the integers between 1 and 50: ");
        int[] numberList = new int[1];
        for (int i = 0; i < numberList.length; i++) {
            numberList[i] = input.nextInt();
            if (numberList[i] == 0) {
                break;
            } else {
                int[] temp = new int[numberList.length + 1];
                System.arraycopy(numberList, 0, temp, 0, numberList.length);
                numberList = temp;
            }
        }
        countOcc(numberList);
    }

    static void countOcc(int[] numberList) {
        Arrays.sort(numberList);
        int occ = 0;
        int currentNumber = numberList[1];
        for (int i = 1; i < numberList.length; i++) {
            if (currentNumber == numberList[i]) {
                occ++;
            } else {
                printOcc(currentNumber, occ);
                currentNumber = numberList[i];
                occ = 1;
            }
        }
        printOcc(currentNumber, occ);
    }

    static void printOcc(int number, int occ) {
        if (occ > 1) {
            System.out.println(number + " occurs " + occ + " times");
        } else {
            System.out.println(number + " occurs " + occ + " time");
        }
    }
}
