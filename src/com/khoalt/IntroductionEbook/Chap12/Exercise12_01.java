package com.khoalt.IntroductionEbook.Chap12;

import java.util.Scanner;

public class Exercise12_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int num1 = input.nextInt();
            String op = input.next();
            int num2 = input.nextInt();
            double result = 0;
            if (op.equals("+")) {
                result = num1 + num2;
            } else if (op.equals("-")) {
                result = num1 - num2;
            } else if (op.equals("*")) {
                result = num1 * num2;
            } else if (op.equals("/")) {
                result = num1 / num2;
            }
            System.out.println(num1 + " " + op + " " + num2 + " = " + result);
        }
        catch (Exception Ex) {
            System.out.println("Wrong input");
        }

    }
}
