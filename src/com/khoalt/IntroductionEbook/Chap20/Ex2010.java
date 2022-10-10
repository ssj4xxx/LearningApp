package com.khoalt.IntroductionEbook.Chap20;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex2010 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("Chemistry", "Mathematics", "Biology", "English"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("Biology", "English", "Geography", "Physics"));

        ArrayList<String> compareList = (ArrayList<String>) list1.clone();
        compareList.removeAll(list2);
        System.out.print("The subjects that are only present in the first stack: ");
        for (int i = 0; i < compareList.size(); i++) {
            if (i == compareList.size() - 1) {
                System.out.println(compareList.get(i));
            } else {
                System.out.print(compareList.get(i) + ", ");
            }
        }

        compareList = (ArrayList<String>) list2.clone();
        compareList.removeAll(list1);
        System.out.print("The subjects that are only present in the second stack: ");
        for (int i = 0; i < compareList.size(); i++) {
            if (i == compareList.size() - 1) {
                System.out.println(compareList.get(i));
            } else {
                System.out.print(compareList.get(i) + ", ");
            }
        }

        compareList = (ArrayList<String>) list2.clone();
        compareList.retainAll(list1);
        System.out.print("The subjects that are only present in the second stack: ");
        for (int i = 0; i < compareList.size(); i++) {
            if (i == compareList.size() - 1) {
                System.out.println(compareList.get(i));
            } else {
                System.out.print(compareList.get(i) + ", ");
            }
        }
    }
}
