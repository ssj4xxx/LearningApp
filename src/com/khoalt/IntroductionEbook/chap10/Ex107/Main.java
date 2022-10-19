package com.khoalt.IntroductionEbook.chap10.Ex107;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static AccountManager am = new AccountManager();
    static int id;

    public static void main(String[] args) {
        am.createAccounts(); //Tao 10 account
        // Loc ID
        do {
            System.out.print("Your ID: ");
            id = input.nextInt();
        } while (id >= 10);
//        Account selectedAccount = am.selectAccount(id);
        // Tao menu
        int choice;
        do {
            System.out.println("1. View the current balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Exit");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    viewBalance();
                    break;
                }
                case 2: {
                    withdrawMoney();
                    break;
                }
                case 3: {
                    depositMoney();
                    break;
                }
            }

        } while (choice != 4);
    }

    public static void viewBalance() {
        am.showBalance(id);
    }

    public static void withdrawMoney() {
        System.out.print("Withdraw amount: ");
        double amount = input.nextDouble();
        am.withdrawAmount(id, amount);
    }

    public static void depositMoney() {
        System.out.print("Deposit amount: ");
        double amount = input.nextDouble();
        am.depositAmount(id, amount);
    }
}
