package com.khoalt;

import java.io.IOException;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(list1 instanceof ArrayList);
        System.out.println(list2 instanceof ArrayList);
    }
}
