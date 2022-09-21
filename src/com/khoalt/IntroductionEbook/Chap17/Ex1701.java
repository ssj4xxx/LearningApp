package com.khoalt.IntroductionEbook.Chap17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex1701 {
    public static void main(String[] args) throws IOException {
        try (
                PrintWriter output = new PrintWriter(new FileOutputStream("Ex1701.txt",
                        true))
        ) {
            for (int i = 0; i < 100; i++) {
                output.print((int)(Math.random() * 100));
                output.print(" ");
            }
        }

    }
}
