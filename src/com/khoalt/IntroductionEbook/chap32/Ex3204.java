package com.khoalt.IntroductionEbook.chap32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex3204 {
    static Integer num = 0;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executor.execute(new Sum());
        }
        executor.shutdown();
    }
    private static class Sum implements Runnable {
        @Override
        public void run() {
            try {
//                synchronized (num) {
                    num = num + 1;
                    System.out.println("The new number is: " + num);
                    Thread.sleep(500);
//                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
