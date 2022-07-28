package com.khoalt.IntroductionEbook.Chap9.Ex96;

public class StopWatch {
    private long startTime, endTime;

    public StopWatch() {
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }


}
