package com.khoalt.IntroductionEbook.chap17.Ex1704;

import java.io.*;

public class Ex1704read {
    public static void main(String[] args) throws IOException {
        try (
                DataInputStream input = new DataInputStream(new FileInputStream("Ex1704.dat"));
        ) {
            System.out.println(input.readInt() + " " + input.readUTF() + " " + input.readDouble());
        }
    }
}
