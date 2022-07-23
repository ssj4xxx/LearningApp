package com.khoalt.SingDimArray;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double[] list = new double[10];
        System.out.println("Nhap 10 so: ");
        for (int i = 0; i < 10; i++) {
            list[i] = input.nextDouble();
        }
        bubleSort(list);
        System.out.println(Arrays.toString(list));
    }

    static void bubleSort(double[] list) {
        double temp = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }
}
