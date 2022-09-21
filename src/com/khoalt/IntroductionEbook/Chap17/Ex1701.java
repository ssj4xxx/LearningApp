package com.khoalt.IntroductionEbook.Chap17;

import java.io.*;

public class Ex1701 {
    public static void main(String[] args) throws IOException {
        try (
            DataOutputStream output = new DataOutputStream(new FileOutputStream("Ex1701.txt",
                    true))
        ) {
            for (int i = 0; i < 10; i++) {
                output.writeInt((int)(Math.random() * 100));
                output.writeUTF(" ");
            }
        }

        try (
                DataInputStream input = new DataInputStream(new FileInputStream("Ex1701.txt"))
        ) {
            for (int i = 0; i < 10; i++) {
                System.out.print(input.readInt());
                System.out.print(input.readUTF());
            }
        }
    }
}
