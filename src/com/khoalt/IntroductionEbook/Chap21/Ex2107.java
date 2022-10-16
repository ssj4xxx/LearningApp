package com.khoalt.IntroductionEbook.Chap21;

import java.util.*;

public class Ex2107 {
    public static void main(String[] args) {
        System.out.println("Nhap text: ");
        Scanner input = new Scanner(System.in);
//        String text = input.nextLine();
        String text = "Khoa Khoa khoa ko hao hoa hao";
        Map<String, Integer> textMap = new TreeMap<String, Integer>();
        String[] words = text.split("[\\s+\\p{P}]");

        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();
            if (!textMap.containsKey(key)) {
                textMap.put(key, 1);
            } else {
                textMap.put(key, textMap.get(key) + 1);
            }
        }
        textMap.forEach((k, v) -> System.out.println(k + "\t" + v));

        // Sort danh sach
        List textList = new ArrayList<>(textMap.entrySet());
        for (Map.Entry<String, Integer> entry : textMap.entrySet()) {
            if (entry.getValue() >= 3) {
                textList.add(entry);
            }
        }



        Collections.sort(textList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(textList);

        List wordList = new ArrayList<String>(textMap.keySet());
        System.out.println(wordList);

//        Set<String> wordSet = new TreeSet<>(textMap.keySet());
//        System.out.println(wordSet);
    }
}
