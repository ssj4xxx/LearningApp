package com.khoalt.TestKhoa.Cht33.chatapp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class ChatServer {
    private ServerSocket serverSocket;
    private Socket socket;

    public static void main(String[] args) throws IOException {
        new ChatServer();
    }
    public ChatServer() {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Conversation started at " + new Date());
            while (!serverSocket.isClosed()) {
                socket = serverSocket.accept();
                System.out.println("A new client has connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                new Thread(clientHandler).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void closeChatServer() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    class ClientHandler implements Runnable {
        public static ArrayList<ClientHandler> clients = new ArrayList<>();
        private Socket socket;
        private BufferedReader inputFromClient;
        private BufferedWriter outputToClient;
        private String clientName;
        public ClientHandler(Socket socket) {
            try {
                this.socket = socket;
                this.outputToClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.clientName = inputFromClient.readLine();
                clients.add(this);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("Client " + clientName + " at " + inetAddress + " has joined the conversation");
            } catch (IOException ex) {

            }


        }
        @Override
        public void run() {
            String messageFromClient;
            while (socket.isConnected()) {
                try {
                    messageFromClient = inputFromClient.readLine();
                    broadcastMessage(messageFromClient);
                } catch (IOException ex) {
                    closeSocket(socket, inputFromClient, outputToClient);
                    break;
                }
            }
        }

        public void broadcastMessage(String message) {
            for (ClientHandler clientHandler : clients) {
                try {
                    if (!clientHandler.clientName.equals(clientName)) {
                        clientHandler.outputToClient.write(message);
                        clientHandler.outputToClient.newLine();
                        clientHandler.outputToClient.flush();
                    }
                } catch (IOException ex) {
                    closeSocket(socket, inputFromClient, outputToClient);
                }
            }
        }

        public void removeCliendHandler() {
            clients.remove(this);
            broadcastMessage(clientName + " has left the conversation.");
        }

        public void closeSocket(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
            removeCliendHandler();
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
