package com.khoalt.IntroductionEbook.chap12;

import java.util.Scanner;

public class Exercise12_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int num1 = Integer.parseInt(args[0]);
            String op = args[1];
            int num2 = Integer.parseInt(args[2]);
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
        catch (NumberFormatException Ex) {
//            exAr
            System.out.println("Wrong input: " + Ex.getMessage());
        }

    }
}
