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
        LinkedList<String> resultList = new LinkedList<>();

        //Todo: Code lai phan convert String thanh List
        expression = insertSpace(expression);
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
            } else if (c.equals(")") || c.length() == 0) {
                continue;
            } else {
                //infix phan trong ngoac don
                c = infixToPostfix(convertToString(exList.subList(i + 1, exList.lastIndexOf(")"))));
                resultList.add(resultList.size() - 1, c);
                i = exList.lastIndexOf(")");
            }
        }
        return convertToString(resultList);
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static String convertToString(List<String> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str = str.concat(list.get(i));
            } else {
                str = str.concat(list.get(i) + " ");
            }
        }
        return str;
    }

    public static String insertSpace(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-' ||
                    str.charAt(i) == '*' || str.charAt(i) == '/')
                result += " " + str.charAt(i) + " ";
            else
                result += str.charAt(i);
        }
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '(') {
//                result = result + str.charAt(i) + " ";
//            } else if (str.charAt(i) == ')') {
//                result = result + " " + str.charAt(i);
//            } else {
//                result = result + str.charAt(i);
//            }
//        }
        return result;
    }
}
