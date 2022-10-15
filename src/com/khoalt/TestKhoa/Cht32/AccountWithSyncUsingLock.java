package com.khoalt.TestKhoa.Cht32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncUsingLock {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPenny());
        }
        executor.shutdown();
        while (!executor.isTerminated()){}
        System.out.println("The final balance is: " + account.getBalance());
    }

    public static class AddAPenny implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }
    public static class Account {
        private int balance = 0;
        private static Lock lock = new ReentrantLock();

        public int getBalance() {return balance;}
        public void deposit(int amount) {
            lock.lock();
            try {
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException ex){
            } finally {
                lock.unlock();
            }
        }
    }
}
