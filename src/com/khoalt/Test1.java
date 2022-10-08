package com.khoalt;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("yellow", "red", "green", "blue");
        List<String> list2 = Arrays.asList("yellow", "red", "green", "blue");
        Collections.shuffle(list1, new Random(20));
        Collections.shuffle(list2, new Random(20));
        System.out.println(new Random(20));
        System.out.println(list1);
        System.out.println(list2);

        Collection<String> collection = Arrays.asList("red", "green", "blue");
        System.out.println(Collections.max(collection));     // Use Comparable
        System.out.println(Collections.min(collection,
                Comparator.comparing(String::length))); // Use Comparator
    }
}
