package com.khoalt.TestKhoa.Cht33.calculateradius;

import javax.imageio.IIOException;
import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Server();
    }
    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
            while (true) {
                double radius = inputFromClient.readDouble();
                double area = radius * radius * Math.PI;
                outputToClient.writeDouble(area);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
