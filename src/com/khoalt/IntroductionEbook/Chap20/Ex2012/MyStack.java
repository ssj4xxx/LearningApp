package com.khoalt.IntroductionEbook.Chap20.Ex2012;

import java.util.List;
import java.util.Stack;

public class MyStack<E> extends Stack<E> {
    public MyStack(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            push(list.get(i));
        }
    }
}
