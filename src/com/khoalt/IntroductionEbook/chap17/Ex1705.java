package com.khoalt.IntroductionEbook.chap17;

import java.io.*;
import java.util.Date;

public class Ex1705 {
    public static void main(String[] args) throws IOException {
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Ex1705.dat"));
        ) {
            for (int i = 0; i < 6; i++) {
                output.writeInt(i + 1);
            }
            Date createdDate = new Date();
            output.writeUTF(createdDate.toString());
            output.writeDouble(10.5);
        }

        try (
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("Ex1705.dat"))
        ) {
            for (int i = 0; i < 6; i++) {
                System.out.println(input.readInt());
            }
            System.out.println(input.readUTF());
            System.out.println(input.readDouble());
        }
    }
}
