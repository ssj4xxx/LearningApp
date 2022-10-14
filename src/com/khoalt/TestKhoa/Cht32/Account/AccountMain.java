package com.khoalt.TestKhoa.Cht32.Account;

public class AccountMain {
    public static void main(String[] args) {
        Account acc = new Account(0);

        Runnable add1Task = new Runnable() {
            @Override
            public void run() {
                acc.addOne();
                System.out.println(acc.getBalance());
            }
        };

//        Thread thread = new Thread(add1Task);
//        thread.run();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(add1Task);
            threads[i].start();
        }
    }
}
