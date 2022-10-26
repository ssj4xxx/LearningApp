package com.khoalt.TestKhoa.Cht33.testpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int port = 8000;
        String host = "localhost";
        DataInputStream in;
        DataOutputStream out;
        Socket socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Scanner input = new Scanner(System.in);
//        System.out.print("Enter a number to be squared: ");
//        double aNumber = input.nextDouble();
//        out.writeDouble(aNumber);
//        System.out.println(in.readDouble());
        System.out.print("Enter your name: ");
        String nickname = input.nextLine();
        out.writeUTF(nickname);
        while (true) {
            out.writeUTF(input.nextLine());
        }
    }
}
