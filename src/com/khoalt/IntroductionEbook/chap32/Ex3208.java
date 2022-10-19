package com.khoalt.IntroductionEbook.chap32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex3208 {
    static Account acc = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();
        System.out.println("Thread 1\t\tThread2\t\tBalance");
    }

    public static class DepositTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    acc.deposit((int) ((Math.random() * 10) + 1));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static class WithdrawTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                acc.withdraw((int) ((Math.random() * 10) + 1));
            }
        }
    }

    public static class Account {
        private int balance = 0;
        private static Lock lock = new ReentrantLock();

        public int getBalance() {
            return balance;
        }

        public synchronized void withdraw(int amount) {
            try {
                while (balance < amount) {
                    System.out.println("\t\t\t" + amount + "Wait for deposit");
                    wait();
                }
                balance = balance - amount;
                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        public synchronized void deposit(int amount) {
                balance = balance + amount;
                System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
                notify();
        }
    }
}
