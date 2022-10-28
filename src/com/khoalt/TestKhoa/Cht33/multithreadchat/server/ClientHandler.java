package com.khoalt.TestKhoa.Cht33.multithreadchat.server;

import com.khoalt.TestKhoa.Cht33.multithreadchat.Client;

import java.io.*;
import java.util.List;

//TODO: xoa client khoi group khi client disconnect
//TODO:
public class ClientHandler implements Runnable {

    private final Client client;
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private final List<Client> clientGroup;

    public ClientHandler(Client client, List<Client> clientGroup) throws IOException {
        this.client = client;
        this.clientGroup = clientGroup;
        this.reader = client.createReader();
        this.writer = client.createWriter();
    }
    @Override
    public void run() {
        String clientName = null;
        try {
            clientName = reader.readLine();
        } catch (IOException e) {
            System.err.println("Failed to read client Name");
            e.printStackTrace();
        }
        clientName = clientName == null ? "//gen random" : clientName;
        this.client.setUsername(clientName);
        // TODO: gen default name
        //cho phep user set username: tin nhan cu phap "/u username"
        //check trung
        try {
            broadcastMessage("has joined the conversation");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send message. Client crashed", e);
        }
        String clientMessage;
        while (client.getSocket().isConnected()) {
            try {
                clientMessage = reader.readLine();
                broadcastMessage(clientMessage);
            } catch (IOException ex) {
                System.err.println("IO Error occured");
                ex.printStackTrace();
                client.closeSocket();
            }
        }

    }
    public void broadcastMessage(String message) throws IOException {
        for (Client client : clientGroup) {
            if (!client.getUsername().equals(this.client.getUsername())) {
                writer.write(client.getUsername() + ": " + message);
                writer.newLine();
                writer.flush();
            }
        }
    }

}