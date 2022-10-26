package com.khoalt.TestKhoa.Cht33.multithreadchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiThreadChatServer {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        new MultiThreadChatServer();
    }
    public MultiThreadChatServer() {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server starts");
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
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
        private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
        private Socket socket;
        private DataInputStream inputFromClient;
        private DataOutputStream outputToClient;

        public ClientHandler(Socket clientSocket) {
            this.socket = clientSocket;
        }
        @Override
        public void run() {
            try {
                inputFromClient = new DataInputStream(socket.getInputStream());
                outputToClient = new DataOutputStream(socket.getOutputStream());
                String clientName = inputFromClient.readUTF();
                broadcastMessage(clientName + " has joined the conversation");
//                outputToClient.writeUTF(clientName + " has joined the conversation");
                clientHandlers.add(this);
                String clientMessage;
                while (socket.isConnected()) {
                    clientMessage = inputFromClient.readUTF();
                    broadcastMessage(clientMessage);
                }
            } catch (IOException ex) {
                closeSocket(socket);
            }
        }
        public void broadcastMessage(String message) {
            for (ClientHandler clientHandler : clientHandlers) {
                try {
                    outputToClient.writeUTF(message);
                    outputToClient.writeUTF("\n");
                    outputToClient.flush();
                } catch (IOException ex) {
                    closeSocket(socket);
                }
            }
        }
        public void closeSocket(Socket socket) {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
