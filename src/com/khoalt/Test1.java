package com.khoalt;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Nhap string: ");
        Scanner input = new Scanner(System.in);
        Object s1 = input.nextLine();
        Integer i1;
        try {
            i1 = Integer.parseInt((String) s1);
            System.out.println(i1.getClass());
        } catch (NumberFormatException ex) {
            System.out.println("Not an integer");
        }
    }
}
