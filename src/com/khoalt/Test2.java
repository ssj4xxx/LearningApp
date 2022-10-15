package com.khoalt;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        System.out.print("Nhap str: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        str.toLowerCase();
        System.out.println(str.toLowerCase());
    }
}
