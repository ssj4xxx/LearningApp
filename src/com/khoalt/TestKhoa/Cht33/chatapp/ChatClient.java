package com.khoalt.TestKhoa.Cht33.chatapp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private Socket socket;
    private BufferedReader inputFromServer;
    private BufferedWriter outputToServer;
    private String clientName;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String clientName = input.nextLine();
        Socket socket = new Socket("localhost", 1234);
        ChatClient client = new ChatClient(socket, clientName);
        client.receiveMessage();
        client.sendMessage();
    }

    public ChatClient(Socket socket, String clientName) {
        try {
            this.socket = socket;
            this.inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.outputToServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientName = clientName;
        } catch (IOException ex) {
            closeSocket(socket, inputFromServer, outputToServer);
        }
    }

    public void sendMessage() {
        try {
            Scanner inputFromKeyboard = new Scanner(System.in);
            while (socket.isConnected()) {
                String messageToSend = inputFromKeyboard.nextLine();
                outputToServer.write(messageToSend);
                outputToServer.newLine();
                outputToServer.flush();
            }
        } catch (IOException ex) {
            closeSocket(socket, inputFromServer, outputToServer);
        }
    }
    public void receiveMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromServer;
                while (socket.isConnected()) {
                    try {
                        messageFromServer = inputFromServer.readLine();
                        System.out.println(messageFromServer);
                    } catch (IOException ex) {
                        closeSocket(socket, inputFromServer, outputToServer);
                    }
                }
            }
        }).start();
    }
    public void closeSocket(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
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
