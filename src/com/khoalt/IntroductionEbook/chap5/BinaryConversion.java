package com.khoalt.IntroductionEbook.chap5;

import java.io.IOException;
import java.util.Scanner;

public class BinaryConversion {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int index = 0;
        System.out.println("Num = ?");
        int num = input.nextInt();
        int bin = 0;

        while(num > 0){
            bin = bin * 10 + num % 2;
            num/=2;
        }
        System.out.format("%08d%n", bin);
    }
}
