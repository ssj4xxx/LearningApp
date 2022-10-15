package com.khoalt.TestKhoa.Cht32;

public class TaskThreadDemo {
    public static void main(String[] args) {
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class PrintChar implements Runnable {
    private char charToPrint;
    private int times;

    public PrintChar(char c, int times) {
        this.charToPrint = c;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

class PrintNum implements Runnable {
    private int times;
    public PrintNum(int times) {
        this.times = times;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                System.out.print(i);
                if (i >= 50) {
                    Thread.sleep(1);
                }
            }
        }
        catch (InterruptedException ex) {
        }

    }
}
