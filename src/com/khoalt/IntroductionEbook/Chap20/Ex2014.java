package com.khoalt.IntroductionEbook.Chap20;

import java.util.Scanner;
import java.util.Stack;

public class Ex2014 {
    public static void main(String[] args) throws Exception {
        Stack<String> expressionStack = new Stack<>();
        Scanner input = new Scanner(System.in);
        for (int i = args.length - 1; i >= 0; i --) {
            expressionStack.push(args[i]);
        }

        int num1, num2 = 0;
        String op;
        num1 = Integer.parseInt((String) expressionStack.pop());
        while (!expressionStack.empty()) {
            if (isNumeric(expressionStack.peek())) {
                num2 = Integer.parseInt(expressionStack.pop());
            } else if (expressionStack.peek().equals("+")) {
                num1 = num1 + num2;
                expressionStack.pop();
            } else if (expressionStack.peek().equals("-")) {
                num1 = num1 - num2;
                expressionStack.pop();
            } else if (expressionStack.peek().equals("*")) {
                num1 = num1 * num2;
                expressionStack.pop();
            } else if (expressionStack.peek().equals("/")) {
                if (num2 == 0) {
                    System.out.println("Khong the chia cho 0");
                    System.exit(1);
                } else {
                    num1 = num1 + num2;
                    expressionStack.pop();
                }
            }
        }
        System.out.println(num1);
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
