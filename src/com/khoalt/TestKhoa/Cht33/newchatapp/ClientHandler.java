package com.khoalt.TestKhoa.Cht33.newchatapp;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clients = new ArrayList<>();
    private Socket socket;
    private BufferedReader inputFromClient;
    private BufferedWriter outputToClient;
    private String clientName;
    public ClientHandler (Socket socket) {
        try {
            this.socket = socket;
            this.inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.outputToClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientName = inputFromClient.readLine();
            clients.add(this);
        } catch (IOException ex) {
            closeSocket(socket, inputFromClient, outputToClient);
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
            }
        }
    }
    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            try {
                if (!client.clientName.equals(clientName)) {
                    client.outputToClient.write(message);
                    client.outputToClient.newLine();
                    client.outputToClient.flush();
                }
            } catch (IOException ex) {
                closeSocket(socket, inputFromClient, outputToClient);
            }
        }
    }
    public void removeClient() {
        clients.remove(this);
        broadcastMessage(this.clientName + " has left the conversation");
    }
    public void closeSocket(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
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