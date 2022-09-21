package com.khoalt.IntroductionEbook.Chap17;

import java.io.*;

public class Ex1703 {
    public static void main(String[] args) throws IOException {
        try (
                DataOutputStream output = new DataOutputStream(new FileOutputStream("Ex1703.dat"))
        ) {
            for (int i = 0; i < 10; i++) {
                output.writeDouble((Math.random() * 100));
                output.writeUTF(" ");
            }
        }

        try (
                DataInputStream input = new DataInputStream(new FileInputStream("Ex1703.dat"))
        ) {
            double sum = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println(sum);
                sum = sum + input.readDouble();
                input.readUTF();
            }
            System.out.println(sum);
        }

    }
}
