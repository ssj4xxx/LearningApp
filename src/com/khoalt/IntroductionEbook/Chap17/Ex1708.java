package com.khoalt.IntroductionEbook.Chap17;

import java.io.RandomAccessFile;

public class Ex1708 {
    public static void main(String[] args) throws Exception {
        try (
                RandomAccessFile inout = new RandomAccessFile("Ex1708.dat", "rw")
        ) {
            if (inout.length() == 0) {
                inout.writeInt(1); // Start count
            } else {
                int count = inout.readInt(); // Read current count
                inout.seek(0); // Move the file pointer to the beginning
                inout.writeInt(++count); // Increment the count
            }
            inout.seek(0);
            System.out.println(inout.readInt());
        }
    }
}
