package com.khoalt.bai1;


import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter an integer");
        int myint = input.nextInt();
        input.nextLine();
        String str = input.nextLine();
        System.out.println(myint);
    }
}
