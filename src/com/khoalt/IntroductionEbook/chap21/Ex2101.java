package com.khoalt.IntroductionEbook.chap21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex2101 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(Arrays.asList("Chemistry", "Mathematics", "Biology", "English"));
        Set<String> set2 = new HashSet<>(Arrays.asList("Biology", "English", "Geography", "Physics"));
        Set<String> resultSet = new HashSet<>();
        resultSet.addAll(set1);

        resultSet.removeAll(set2);
        System.out.println("only present in the first stack: " + resultSet);

        resultSet.clear();
        resultSet.addAll(set2);
        resultSet.removeAll(set1);
        System.out.println("only present in the second stack: " + resultSet);

        resultSet.clear();
        resultSet.addAll(set2);
        resultSet.retainAll(set1);
        System.out.println("present in both stacks: " + resultSet);
    }
}
