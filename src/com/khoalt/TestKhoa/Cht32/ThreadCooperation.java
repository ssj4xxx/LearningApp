package com.khoalt.TestKhoa.Cht32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    public static Account account = new Account();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();
        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    private static class DepositTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    account.deposit((int)(Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class WithdrawTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                account.withdraw((int)(Math.random() * 10) + 1);
            }
        }
    }

    private static class Account {
        private int balance = 0;
        private static Lock lock = new ReentrantLock();
        private static Condition newDeposit = lock.newCondition();
        public int getBalance() {return balance;}
        public void withdraw(int amount) {
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.printf("\t\tWait for Deposit");
                    newDeposit.await();
                }
                balance = balance - amount;
                System.out.println("\t\tWithdraw " + amount +"\t\t" + getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void deposit(int amount) {
            lock.lock();
            try {
                balance = balance + amount;
                System.out.println("\t\tDeposit " + amount + "\t\t" + getBalance());
                newDeposit.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
