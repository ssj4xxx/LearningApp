package com.khoalt.IntroductionChap9.Ex97;

import java.util.Scanner;

public class AccountManager {
    static Account firstAccount = new Account(1122, 20000, 0.045);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Account " + firstAccount.getId() + ": Balance - " + firstAccount.getBalance() + "$, Monthy Interest - " + firstAccount.getMonthlyInterest() + "$");
        input.nextLine();
        System.out.println("Withdraw 2500");
        firstAccount.withdraw(2500);
        System.out.print("Account " + firstAccount.getId() + ": Balance - " + firstAccount.getBalance() + "$, Monthy Interest - " + firstAccount.getMonthlyInterest() + "$");
        input.nextLine();
        System.out.println("Deposit 3000");
        firstAccount.deposit(3000);
        System.out.println("Account " + firstAccount.getId() + ": Balance - " + firstAccount.getBalance() + "$, Monthy Interest - " + firstAccount.getMonthlyInterest() + "$");
    }
}
