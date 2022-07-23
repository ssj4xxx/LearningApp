package com.khoalt.IntroductionChap9;

import java.util.Scanner;

class StopWatch {
    private static long startTime, endTime;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to start");
        input.nextLine();
        start();
        System.out.println("Press Enter to end");
        input.nextLine();
        end();
        System.out.println(getElapsedTime());
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void end() {
        endTime = System.currentTimeMillis();
    }

    public static long getElapsedTime() {
        return endTime - startTime;
    }

}
