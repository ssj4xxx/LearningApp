package com.khoalt.OldEx;

import java.util.Scanner;

class Palindrome {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap so bat ky: ");
        int number = keyboard.nextInt();
        keyboard.nextLine();
        int numberLength = String.valueOf(number).length();
        boolean isPalindrome = true;

        for (int count = 0; count < numberLength; count ++){
            int firstDigit = getDigit(number, count);
            int lastDigit = getDigit(number, numberLength - count - 1);
            if (firstDigit != lastDigit){
                isPalindrome = false;
                break;
            }
        }

        String result = isPalindrome ? "Palindrome" : "Not Palindrome";
        System.out.println(result);
    }

    static int getDigit(int number, int index){
        return String.valueOf(number).charAt(index);
    }
}
