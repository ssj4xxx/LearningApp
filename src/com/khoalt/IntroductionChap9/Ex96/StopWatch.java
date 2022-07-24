package com.khoalt.IntroductionChap9.Ex96;

import java.util.Arrays;
import java.util.Scanner;

public class StopWatch {
    private static long startTime, endTime;

    public StopWatch() {
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
