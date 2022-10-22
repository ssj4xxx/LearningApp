package com.khoalt.TestKhoa.Cht33.testpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8000;

        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;


//        server = new ServerSocket(port);
//        socket = server.accept();
//        in = new DataInputStream(socket.getInputStream());
//        out = new DataOutputStream(socket.getOutputStream());
//        System.out.println(in.readDouble());
//        out.writeDouble(aNumber);
    }

}
