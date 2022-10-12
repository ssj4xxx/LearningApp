package com.khoalt.TestKhoa.Cht21;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("London");
        set.add("Ninh Binh");
        set.add("Ha Noi");
        set.add("New York");
        set.add("Ha Noi");
        set.add("Da Nang");

        System.out.println(set);
        set.forEach(e -> System.out.print(e.toUpperCase() + " "));
    }
}
