package com.khoalt.OldEx;

import java.util.Scanner;

class PTB2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap he so a b c: ");
        double a = keyboard.nextInt();
        keyboard.nextLine();
        double b = keyboard.nextInt();
        keyboard.nextLine();
        double c = keyboard.nextInt();
        keyboard.nextLine();
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0){
            System.out.println("Phuong trinh vo nghiem");
        }
        else if (delta == 0){
            double nghiem = (- b + Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co 1 nghiem la: " + nghiem);
        }
        else{
            double x1 = (- b + Math.sqrt(delta)) / (2 * a);
            double x2 = (- b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co 2 nghiem la: " + x1 + " va " + x2);
        }
    }
}
