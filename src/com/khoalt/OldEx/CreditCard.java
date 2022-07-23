package com.khoalt.OldEx;

import java.util.Scanner;

class CreditCard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap card number: ");
        long creditCard = keyboard.nextLong();
        String result = isValid(creditCard) ? "Hop le" : "Khong hop le";
        System.out.println(result);
    }

    static boolean isValid(long number){
        return ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) && isRightPrefix(number) && (getSize(number) >= 13) && (getSize(number) <= 16);
    }

    static int sumOfDoubleEvenPlace(long number){
        int temp = 0;
        if (getSize(number) % 2 == 0){
            for (int count = 0; count < getSize(number) / 2; count++){
                int evenDigit = String.valueOf(number).charAt(count * 2) - '0';
                temp = temp + getDigit(evenDigit);
            }
        }
        else {
            for (int count = 0; count < getSize(number) / 2; count++){
                int evenDigit = String.valueOf(number).charAt(count * 2 + 1) - '0';
                temp = temp + getDigit(evenDigit);
            }
        }
        return temp;
    }

    static int getDigit(int number){
        int doubleNumber = number * 2;
        if (number > 4){
            return doubleNumber % 10 + doubleNumber / 10;
        }
        else{
            return doubleNumber;
        }
    }

    static int sumOfOddPlace(long number){
        int temp = 0;
        if (getSize(number) % 2 == 0){
            for (int count = 0; count < getSize(number) / 2; count++){
                int oddDigit = String.valueOf(number).charAt(count * 2 + 1) - '0';
                temp = temp + oddDigit;
            }
        }
        else {
            for (int count = 1; count < getSize(number) / 2; count++){
                int oddDigit = String.valueOf(number).charAt(count * 2) - '0';
                temp = temp + oddDigit;
            }

        }
        return temp;
    }

    static int getSize(long number){
        return String.valueOf(number).length();
    }

    static boolean isRightPrefix(long number){
        int firstDigit = getPrefix(number, 1);
        int first2Digits = getPrefix(number, 2);
        return (firstDigit == 4) || (firstDigit == 5) || (firstDigit == 6) ||  (first2Digits == 37);
    }

    static int getPrefix(long number, int numberOfDigit){
        String temp = "";
        for (int count = 0; count < numberOfDigit; count++){
            temp = temp + String.valueOf(number).charAt(count);
        }
        return Integer.valueOf(temp);
    }



}
