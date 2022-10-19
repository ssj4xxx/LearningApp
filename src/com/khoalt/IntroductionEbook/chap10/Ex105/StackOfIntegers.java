package com.khoalt.IntroductionEbook.chap10.Ex105;

public class StackOfIntegers {
    private int[] numbers;

    public StackOfIntegers() {
    }

    public StackOfIntegers(int[] list) {
        int length = list.length;
        int[] reverseList = new int[length];
        for (int i = 0; i < length; i++) {
            reverseList[length - i - 1] = list[i];
        }
        numbers = reverseList;
    }

    public int getFactor(int i) {
        return numbers[i];
    }

    public void printStack() {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
