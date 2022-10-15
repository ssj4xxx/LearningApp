package com.khoalt.TestKhoa.Cht21;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Hanoi");
        set.add("Da Nang");
        set.add("Ninh Binh");
        set.add("Hanoi");
        set.add("New York");

        System.out.println(set);
        set.forEach(e -> System.out.print(e.toUpperCase() + " "));
    }
}
