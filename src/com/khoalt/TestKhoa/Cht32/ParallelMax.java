package com.khoalt.TestKhoa.Cht32;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMax {
    public static void main(String[] args) {
        final int N = 9000000;
        int[] list = new int[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("\nThe max number is " + max(list));
        long endTime = System.currentTimeMillis();
        System.out.println("The number of processor is " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time is " + (endTime - startTime));
    }
    public static int max(int[] list) {
        RecursiveTask<Integer> mainTask = new MaxTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(mainTask);
    }

    private static class MaxTask extends RecursiveTask<Integer> {
        private int[] list;
        private final static int THRESHOLD = 1000;
        private int low;
        private int high;
        public MaxTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }
        @Override
        protected Integer compute() {
            if (high - low < THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++) {
                    if (list[i] > max) {
                        max = list[i];
                    }
                }
                return max;
            } else {
                int mid = (low + high) / 2;
                RecursiveTask<Integer> firstHalfMax = new MaxTask(list, low, mid);
                RecursiveTask<Integer> secondHalfMax = new MaxTask(list, mid, high);
                firstHalfMax.fork();
                secondHalfMax.fork();
                return Math.max(firstHalfMax.join().intValue(), secondHalfMax.join().intValue());
            }
        }
    }
}
