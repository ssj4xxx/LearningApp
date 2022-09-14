package com.khoalt.TestKhoa.Cht13;

import java.io.*;
public class TestDataStream {
    public static void main(String[] args) throws IOException {
        try ( // Create an output stream for file temp.dat
              DataOutputStream output =
                      new DataOutputStream(new FileOutputStream("temp.dat"));
        ) {
            // Write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Susan");
            output.writeDouble(185.5);
            output.writeUTF("Kim");
            output.writeDouble(105.25);
        }
        try ( // Create an input stream for file temp.dat
              DataInputStream input =
                      new DataInputStream(new FileInputStream("temp.dat"));
        ) {
            // Read student test scores from the file
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }

        try ( // Create an output stream for file temp.dat
              DataOutputStream output =
                      new DataOutputStream(new FileOutputStream("temp.dat", true));
        ) {
            // Write student test scores to the file
            output.writeUTF("Test");
            output.writeDouble(81.5);
            output.writeUTF("Test2");
            output.writeDouble(181.5);
            output.writeUTF("Test3");
            output.writeDouble(101.25);
        }
        try ( // Create an input stream for file temp.dat
              DataInputStream input =
                      new DataInputStream(new FileInputStream("temp.dat"));
        ) {
            // Read student test scores from the file
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}