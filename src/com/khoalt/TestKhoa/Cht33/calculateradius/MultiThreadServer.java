package com.khoalt.TestKhoa.Cht33.calculateradius;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadServer {
    public static void main(String[] args) {
        new MultiThreadServer();
    }
    public MultiThreadServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("MultiThreadServer started at " + new Date() + '\n');
            int clientNo = 1;
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Starting thread for client " + clientNo + " at " + new Date() + '\n');
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("Client " + clientNo + "'s hostname is " + inetAddress.getHostName());
                System.out.println("Client " + clientNo + "'s IP address is " + inetAddress.getHostAddress());
                HandleAClient task = new HandleAClient(socket);
                new Thread(task).start();
                clientNo++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class HandleAClient implements Runnable {
        private Socket socket;
        public HandleAClient(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    double radius = inputFromClient.readDouble();
                    double area = radius * radius * Math.PI;
                    outputToClient.writeDouble(area);
                    System.out.println("radius received from the client: " + radius + '\n');
                    System.out.println("Area found: " + area + '\n');
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
