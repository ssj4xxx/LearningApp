package com.khoalt.IntroductionEbook.Chap21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex2104 {
    static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static int vowelCount = 0;
    static int totalCount = 0;
    public static void main(String[] args) {
        File textFile = new File(args[0]);
        String word = "";
        try (Scanner input = new Scanner(textFile)) {
            while (input.hasNext()) {
                word = input.next();
                totalCount = totalCount + word.length();
                countChar(word);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + (totalCount - vowelCount));
    }

    public static void countChar(String str) {
        String strLowerCase = str.toLowerCase();
        for(char c : strLowerCase.toCharArray()) {
            if (vowels.contains(c)) {
                vowelCount++;
            }
        }
    }
}
