package com.khoalt.IntroductionEbook.chap32;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex3209 {
    static Set<Integer> numberSet = Collections.synchronizedSet(new HashSet<>());
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new AddNumberTask());
        executor.execute(new NumberSetIterator());
        executor.shutdown();
    }

    static class AddNumberTask implements Runnable {
        @Override
        public void run() {
            synchronized (numberSet) {
                int count = 0;
                while (count < 10) {
                    numberSet.add((int) (Math.random() * 100));
                    System.out.println("Added");
                    count++;
                }
            }

        }
    }

    static class NumberSetIterator implements Runnable {
        @Override
        public void run() {
            synchronized (numberSet) {
                Iterator<Integer> iterator = numberSet.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next() + " ");
                }
                System.out.println();
            }
        }

    }
}
