package com.khoalt.IntroductionEbook.chap17.Ex1704;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1704write {
    public static void main(String[] args) throws IOException {
        try (
                DataOutputStream output = new DataOutputStream(new FileOutputStream("Ex1704.dat"));
        ) {
            output.writeInt(001);
            output.writeUTF("Khoa");
            output.writeDouble(95.99);
        }
    }
}
