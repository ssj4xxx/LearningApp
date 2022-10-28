package com.khoalt.TestKhoa.Cht33.multithreadchat.server;

import com.khoalt.TestKhoa.Cht33.multithreadchat.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer implements Runnable {
    private final int port;
    private final ServerSocket serverSocket;
    private static final List<Client> clientGroup = Collections.synchronizedList(new ArrayList<>());

    public ChatServer(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected");
                Client client = new Client(clientSocket);
                clientGroup.add(client);
                ClientHandler clientHandler = new ClientHandler(client, clientGroup);
                new Thread(clientHandler).start();
            }
        } catch (Exception ex){
            System.err.println("Server error");
            ex.printStackTrace();
        } finally {
            closeSocket();
        }
    }

    public void closeSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            var chatServer = new Thread(new ChatServer(1234));

            chatServer.start();
            chatServer.isAlive();
            System.out.println("Server started");
        } catch (IOException e) {
            System.err.println("Failed to create chat server");
            e.printStackTrace();
        }
    }


}
