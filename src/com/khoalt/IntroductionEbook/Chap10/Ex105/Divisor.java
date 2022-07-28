package com.khoalt.IntroductionEbook.Chap10.Ex105;

import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so tu nhien: ");
        int number = input.nextInt();
//        int[] list = divisors(12);
        printList(divisors(number));
        StackOfIntegers divisors1 = new StackOfIntegers(divisors(number));
        divisors1.printStack();
    }

    public static int[] divisors(int number) {
        int i = number / 2;
        int numberOfDivisors = 0;
        int[] list = {1};
        while (i >= 1) {
            if (number % i == 0) {
                numberOfDivisors = numberOfDivisors + 1;
                int[] newList = new int[numberOfDivisors];
                System.arraycopy(list, 0, newList, 0, numberOfDivisors - 1);
                list = newList;
                list[numberOfDivisors - 1] = i;
            }
            i = i - 1;
        }
        return list;
    }

    public static void printList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " ");
        }
    }

}
