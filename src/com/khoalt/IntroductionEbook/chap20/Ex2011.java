package com.khoalt.IntroductionEbook.chap20;

import java.util.Scanner;
import java.util.Stack;

public class Ex2011 {
    public static void main(String[] args) {
        System.out.println("Nhap 10 integer: ");
        Scanner input = new Scanner(System.in);
        Stack<Integer> intStack = new Stack<>();
        for (int i = 0; i < 10 ; i++) {
            intStack.push(input.nextInt());
        }
        System.out.println("Original order: " + intStack.toString());

        Stack<Integer> revserseStack = new Stack<>();
        while (!intStack.empty()) {
            if (!revserseStack.contains(intStack.peek())) {
                revserseStack.push(intStack.pop());
            } else {
                intStack.pop();
            }
        }
        System.out.println("Reverse order: " + revserseStack.toString());
    }
}
