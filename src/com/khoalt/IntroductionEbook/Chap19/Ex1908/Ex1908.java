package com.khoalt.IntroductionEbook.Chap19.Ex1908;

import java.util.ArrayList;

public class Ex1908 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(list.toString());
        shuffle(list);
        System.out.println(list.toString());
    }

    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int index = (int)(Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}
