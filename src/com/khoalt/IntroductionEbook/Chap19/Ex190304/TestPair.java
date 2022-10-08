package com.khoalt.IntroductionEbook.Chap19.Ex190304;

public class TestPair {
    public static void main(String[] args) {
        Pair<Integer> p1 = new Pair<>(1, 2);
        System.out.println(smallestValue(p1));
        Pair<Double> p2 = new Pair<>(7.0, 6.3);
        System.out.println(smallestValue(p2));
        Pair<String> p3 = new Pair<>("big", "small");
        System.out.println(smallestValue(p3));
        /* Lines below are not compilable because Color is not comparable
            Pair<String> pc = new Pair<>(java.awt.Color.BLUE, java.awt.Color.RED);
            System.out.println(smallest(ps));*/
    }

    public static <T extends Comparable<T>> T smallestValue(Pair<T> p) {
        if (p.obj1.compareTo(p.obj2) < 0) {
            return p.obj1;
        } else {
            return p.obj2;
        }
    }
}
