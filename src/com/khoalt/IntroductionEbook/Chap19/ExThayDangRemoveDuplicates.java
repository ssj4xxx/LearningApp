package com.khoalt.IntroductionEbook.Chap19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExThayDangRemoveDuplicates {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(1);
        intList.add(2);
        intList.add(5);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(1);
        stack.push(7);
        stack.push(3);
//        System.out.println("Old list: " + stack.toString());
//        removeDuplicates(stack);
//        System.out.println("New list: " + stack.toString());
        TextFileCollection file = new TextFileCollection(new File("testrd.txt"));
        System.out.println(file);
        removeDuplicates(file);
        System.out.println(file);
    }

    //TODO: implement
    public static <E> void removeDuplicates(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }
}
