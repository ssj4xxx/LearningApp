package com.khoalt;

public class Test1 {

    public static int quotient(int number1, int number2) {
//        if (number2 == 0)
//            throw new ArithmeticException("Divisor cannot be zero");
        return number1 / number2;
    }

    public static void main(String[] args) {
        Integer number = 1;
        boolean isInt = number instanceof Integer;
        System.out.println(number.getClass().getName() + isInt);
    }

}
