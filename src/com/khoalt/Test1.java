package com.khoalt;

public class Test1 {

    public static int quotient(int number1, int number2) {
//        if (number2 == 0)
//            throw new ArithmeticException("Divisor cannot be zero");
        return number1 / number2;
    }

    public static void main(String[] args) {
        String s1 = "John Dugn Khoa Dung Khoa Khoa Dung John";
        String s2 = s1.replaceAll("John", "");
        System.out.println(s2);
//        PrintWriter output = new PrintWriter("test.txt");
//        output.print("fjkshdfjkdshjkf");
    }

}
