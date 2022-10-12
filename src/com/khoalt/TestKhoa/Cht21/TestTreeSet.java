package com.khoalt.TestKhoa.Cht21;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Ninh Binh");
        set.add("Ha Noi");
        set.add("New York");
        set.add("Ha Noi");
        set.add("Da Nang");

        TreeSet<String> treeSet = new TreeSet<>(set);
        System.out.println(treeSet);

        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("headSet(\"New York\"): " + treeSet.headSet("New York"));
        System.out.println("tailSet(\"New York\"): " + treeSet.tailSet("New York"));
    }
}
