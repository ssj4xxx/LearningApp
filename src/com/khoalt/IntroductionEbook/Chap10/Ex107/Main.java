package com.khoalt.IntroductionEbook.Chap10.Ex107;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static AccountManager am = new AccountManager();

    public static void main(String[] args) {
        am.createAccounts();
        System.out.println("Nhap chinh xac id: ");
        int id = input.nextInt();
        if (id < 10) {
            Account selectedAccount = am.selectAccount(id);
        } else {
            System.out.println("Error");
        }

//        int choice;
//        do {
//            System.out.println("1. View the current balance");
//            System.out.println("2. Withdraw money");
//            System.out.println("3. Deposit money");
//            System.out.println("4. Exit");
//            choice = input.nextInt();
//            input.nextLine();
//
//        } while (choice != 0);
    }
}
