package com.khoalt;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        System.out.println("Nhap string: ");
//        Scanner input = new Scanner(System.in);
//        Object s1 = input.nextLine();
//        Integer i1;
//        try {
//            i1 = Integer.parseInt((String) s1);
//            System.out.println(i1.getClass());
//        } catch (NumberFormatException ex) {
//            System.out.println("Not an integer");
//        }

        List<String> list = new ArrayList<>();
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("test");
        System.out.println(list.toString());
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str = str.concat(list.get(i));
            } else {
                str = str.concat(list.get(i) + " ");
            }
        }
        System.out.println(str);
    }
}
