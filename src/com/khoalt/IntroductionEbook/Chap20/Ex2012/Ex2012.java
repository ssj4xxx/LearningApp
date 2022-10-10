package com.khoalt.IntroductionEbook.Chap20.Ex2012;

import java.util.Arrays;
import java.util.List;

public class Ex2012 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        MyStack<Integer> intStack2012 = new MyStack<>(intList);
        System.out.println(intList.toString());
    }
}
