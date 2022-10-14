package com.khoalt.TestKhoa.Cht32.Account;

public class Account {
    private double balance;
    public Account(){};
    public Account(double balance) {
        this.balance = balance;
    }

    public void addOne() {
        balance = balance + 1;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
