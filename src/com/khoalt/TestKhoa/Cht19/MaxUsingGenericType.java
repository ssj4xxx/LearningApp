package com.khoalt.TestKhoa.Cht19;

public class MaxUsingGenericType {
    public static void main(String[] args) {
        // 23 is autoboxed into an Integer object
        MaxUsingGenericType.max(24, 23);

        GenericStack stack;
        stack = new GenericStack<String>();
        stack.push("Welcome to Java");
        stack.push(Integer.valueOf(2));
        System.out.println(stack.toString());
    }
    /** Return the maximum of two objects */
    public static <E  extends Comparable<E>> E max(E o1, E o2) {
        if (o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
    }
}