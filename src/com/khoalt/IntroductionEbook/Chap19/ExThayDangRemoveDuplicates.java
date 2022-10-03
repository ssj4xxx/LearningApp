package com.khoalt.IntroductionEbook.Chap19;

import java.util.ArrayList;

public class ExThayDangRemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(1);
        intList.add(2);
        intList.add(5);
        System.out.println("Old list: " + intList.toString());
        intList = removeDuplicates(intList);
        System.out.println("New list: " + intList.toString());
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> finalList = new ArrayList<E>();
        int index = 0;
        while (index < list.size()) {
            if (!finalList.contains(list.get(index))) {
                finalList.add(list.get(index));
            }
            index++;
        }
        return finalList;
    }
}
