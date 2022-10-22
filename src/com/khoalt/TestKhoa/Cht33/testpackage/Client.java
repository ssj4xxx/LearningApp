package com.khoalt.TestKhoa.Cht33.testpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 8000;

        String host = "localhost"
        DataInputStream in;
        DataOutputStream out;
        Socket socket;

//        socket = new Socket(host, port);
//        in = new DataInputStream(socket.getInputStream());
//        out = new DataOutputStream(socket.getOutputStream());
//
//        System.out.println(in.readDouble());
//
//        out.writeDouble(aNumber);
    }
}
