package com.khoalt.TestKhoa.Cht21;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        //Create a map
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);

        System.out.println("Display all entries: ");
        System.out.println(hashMap + "\n");

        //Create a TreeMap from HashMap
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display all entries: ");
        System.out.println(treeMap + "\n");

        // Create a LinkedHashMap
        // from hashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(hashMap);
        System.out.println("Display all entries: ");
        System.out.println(hashMap + "\n");
        //Insertion Order + Access Order
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " +
                linkedHashMap.get("Lewis"));
        System.out.println(linkedHashMap);
        System.out.print("\nNames and ages are ");
        treeMap.forEach((name, age) -> System.out.print(name + ": " + age + " "));
    }
}