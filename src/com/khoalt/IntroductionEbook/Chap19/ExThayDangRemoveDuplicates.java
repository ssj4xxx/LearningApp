package com.khoalt.IntroductionEbook.Chap19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

        DogAction dogAction = new Person();


        var test = new ArrayList<DogAction>((Collection<? extends DogAction>) new Person());
//        System.out.println("Old list: " + stack.toString());
//        removeDuplicates(stack);
//        System.out.println("New list: " + stack.toString());
        FileLinesList file = new FileLinesList(new File("testrd.txt"));

        test.a
        List<String> randomTextList = new FileLinesList();
        randomTextList.add("Khoa");


        var fileLinesList = new FileLinesList(randomTextList);
        fileLinesList.writeToFile();




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
