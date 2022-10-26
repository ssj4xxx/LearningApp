package com.khoalt.TestKhoa.Cht33.testpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8000;

        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        server = new ServerSocket(port);
        Socket socket = server.accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
//        double numberFromClient = in.readDouble();
//        double sqr = numberFromClient * numberFromClient;
//        out.writeDouble(sqr);
        String nickname = in.readUTF();
        while (true) {
            System.out.println(nickname + ": " + in.readUTF());
        }
    }

}
