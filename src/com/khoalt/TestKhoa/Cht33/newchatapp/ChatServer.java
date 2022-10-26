package com.khoalt.TestKhoa.Cht33.newchatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private ServerSocket serverSocket;
    public static void main(String[] args) throws IOException {
        ChatServer server = new ChatServer(new ServerSocket(1234));
        System.out.println("Start chatting");
        server.startServer();
    }
    public ChatServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
     }
    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has been connected");
                ClientHandler clientHandler = new ClientHandler(socket);
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

}
