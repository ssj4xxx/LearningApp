package com.khoalt.IntroductionChap9;

import java.util.Scanner;

public class StopWatch {
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

    public static long getEndTime() {
        return endTime;
    }

    public static long getStartTime() {
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
