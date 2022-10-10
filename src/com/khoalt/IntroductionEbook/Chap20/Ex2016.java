package com.khoalt.IntroductionEbook.Chap20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ex2016 {
    public static void main(String[] args) {
        System.out.println("Nhap bieu thuc: ");
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        System.out.println(infixToPostfix(expression));
    }

    public static String infixToPostfix(String expression) {
        LinkedList<String> valueList = new LinkedList<>();
        LinkedList<String> opList = new LinkedList<>();
        LinkedList<String> resultList = new LinkedList<>();
        LinkedList<String> exList = new LinkedList<>(Arrays.asList(expression.split(" ")));
        String c;
        for (int i = 0; i < exList.size(); i++) {
            c = exList.get(i);
            if (isNumeric(c)) {
                if (i == 0) {
                    resultList.add(c);
                } else {
                    resultList.add(resultList.size() - 1, c);
                }
            } else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                resultList.addLast(c);
            } else {
                c = infixToPostfix(convertToString(exList.subList(i + 1, exList.lastIndexOf(")"))));
                resultList.add(resultList.size() - 1, c);
                i = exList.lastIndexOf(")");
            }
        }
        return resultList.toString();
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static String convertToString(List<String> list) {
        String str = null;
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str.concat(list.get(i));
            } else {
                str.concat(list.get(i) + " ");
            }
        }
        return str;
    }
}
