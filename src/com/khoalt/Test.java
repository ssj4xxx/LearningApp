package com.khoalt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao 1 so nguyen: ");
        int soNguyen = input.nextInt();
        if (soNguyen >= 0) {
            System.out.println("Day la so nguyen duong.");
        } else {
            System.out.println("Day la so nguyen am.");
        }
    }
}
