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

        // Tao list co value>=3
        List textList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : textMap.entrySet()) {
            if (entry.getValue() >= 2) {
                textList.add(entry);
            }
        }
        // Sort list
        Collections.sort(textList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(textList);

        List allList = new ArrayList<>(textMap.entrySet());
        System.out.println(allList.get(0));

//        // Use ArraysList, Array
//        List<String> wordList = new ArrayList<String>();
//        List<Integer> countList = new ArrayList<Integer>();
//        for (Map.Entry<String, Integer> entry : textMap.entrySet()) {
//            if (entry.getValue() >= 2) {
//                wordList.add(entry.getKey());
//                countList.add(entry.getValue());
//            }
//        }
//        for (int i = 0; i < wordList.size(); i++) {
//            System.out.println(wordList.get(i) + "\t" + countList.get(i));
//        }
//        String[] wordArray = new String[wordList.size()];
//        wordList.toArray(wordArray);
//        Integer[] countArray = new Integer[countList.size()];
//        countList.toArray(countArray);
//        for (int i = 0; i < wordArray.length; i++) {
//            for (int j = i + 1; j< wordArray.length; j++) {
//                int temp = 0;
//                String tempStr = "";
//                if (countArray[j] > countArray[i]) {
//                    temp = countArray[i];
//                    countArray[i] = countArray[j];
//                    countArray[j] = temp;
//                    tempStr = wordArray[i];
//                    wordArray[i] = wordArray[j];
//                    countArray[j] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < wordArray.length; i++) {
//            System.out.println(wordArray[i] + "\t" + countArray[i]);
//        }
    }
}
