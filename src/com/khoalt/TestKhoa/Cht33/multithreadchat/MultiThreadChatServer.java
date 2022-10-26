package com.khoalt.TestKhoa.Cht33.multithreadchat;

import com.khoalt.TestKhoa.Cht33.calculateradius.MultiThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadChatServer {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        new MultiThreadServer();
    }
    public MultiThreadChatServer() {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server starts");
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connectec");
                ClientHandler clientHandler = new ClientHandler();
                new Thread(clientHandler).start();
            }
        } catch (IOException ex) {
            closeServer();
        }
    }
    public void closeServer() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class ClientHandler implements Runnable {
        public ClientHandler() {

        }
        @Override
        public void run() {

        }
    }
}
