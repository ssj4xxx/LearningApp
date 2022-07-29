package com.khoalt.IntroductionEbook.Chap10.Ex107;

public class AccountManager {
    private Account[] accountList = new Account[10];

    public Account[] createAccounts() {
        for (int i = 0; i < 10; i++) {
            this.accountList[i] = new Account(i, 100, 0.1);
        }
        return accountList;
    }

    public Account selectAccount(int id) {
        return accountList[id];
    }

    public void showBalance(int id) {
        System.out.println("Account " + id + " current balance: " + accountList[id].getBalance());
    }

    public boolean withdrawAmount(int id, double amount) {
        if (amount > accountList[id].getBalance()) {
            System.out.println("Not enough money");
            return false;
        } else {
            accountList[id].setBalance(accountList[id].getBalance() - amount);
            System.out.println("Succes");
            return true;
        }
    }

    public boolean depositAmount(int id, double amount) {
        accountList[id].setBalance(accountList[id].getBalance() + amount);
        System.out.println("Success");
        return true;
    }




}
