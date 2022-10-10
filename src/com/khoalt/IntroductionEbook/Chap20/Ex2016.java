package com.khoalt.IntroductionEbook.Chap20;

import java.util.Arrays;
import java.util.LinkedList;

public class Ex2016 {
    public static void main(String[] args) {

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
                resultList.push(c);
            } else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                opList.push(c);
            } else {

            }
        }
        return null;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
