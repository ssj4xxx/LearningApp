package com.khoalt.IntroductionEbook.chap19.Ex1902;

import java.util.Scanner;

public class TestNewGenericStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        NewGenericStack<String> stack = new NewGenericStack<>();

        System.out.print("Enter five strings: ");
        for (int i = 0; i < 5; i++)
            stack.push(input.next());
        System.out.println(stack.toString());

//         Display the strings in reverse order
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }
}
