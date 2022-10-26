package com.khoalt.TestKhoa.Cht33.chatapp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private Socket socket;
    private BufferedReader inputFromServer;
    private BufferedWriter outputToServer;
    private String clientName;
    public static void main(String[] args) {
        new ChatClient();
    }
    public ChatClient() {
        try {
            socket = new Socket("localhost", 1234);
            inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputToServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.print("Enter your name: ");
            clientName = inputFromServer.readLine();
            outputToServer.write(clientName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void sendMessage() {
        try {
//            outputToServer.write();
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
