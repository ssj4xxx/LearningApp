package com.khoalt.IntroductionEbook.chap19.Ex1902;

import java.util.ArrayList;

public class NewGenericStack<E> extends ArrayList<E> {
    public E peek() {
        return get(size() - 1);
    }

    public void push(E o) {
        add(o);
    }


    public E pop() {
        E o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    @Override
    public String toString() {
        return "stack: " + super.toString();
    }
}
