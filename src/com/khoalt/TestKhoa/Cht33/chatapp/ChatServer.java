package com.khoalt.TestKhoa.Cht33.chatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ChatServer {
    public static void main(String[] args) {
        new ChatServer();
    }
    public ChatServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Conversation started at " + new Date());
            while (true) {
                Socket socket = serverSocket.accept();
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                InetAddress inetAddress = socket.getInetAddress();
                String clientName = inputFromClient.readUTF();
                System.out.println("Client " + clientName + " has joined the conversation");
                ClientHandler task = new ClientHandler(socket);
                new Thread(task).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {
        private Socket socket;
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String message = inputFromClient.readUTF();
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
