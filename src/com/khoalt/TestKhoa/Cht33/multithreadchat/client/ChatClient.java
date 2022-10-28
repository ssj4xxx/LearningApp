package com.khoalt.TestKhoa.Cht33.multithreadchat.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private final Socket socket;
    private final DataInputStream inputFromServer;
    private final DataOutputStream outputToServer;
    String username;

    //1 ham chi lam 1 viec duy nhat
    public ChatClient(Socket socket) throws IOException {
        this.socket = socket;
        inputFromServer = new DataInputStream(socket.getInputStream()); //thay bang text stream
        outputToServer = new DataOutputStream(socket.getOutputStream());
        initClient();
    }

    public void initClient(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your name: ");
            username = input.nextLine();
            outputToServer.writeUTF(username);
            outputToServer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            closeSocket(socket); //never omit exception
        }
    }
    //1 ham chi lam 1 viec
    //Single Responsibility Principle
    // 1 class
    public void createSender() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        Scanner input = new Scanner(System.in);
                        outputToServer.writeUTF(input.nextLine());
                        outputToServer.flush();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        closeSocket(socket);
                    }
                }
                System.out.println("socket closed. Sender close....");
            }
        }).start();
    }
    public void createReceiver() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        System.out.println(inputFromServer.readUTF());
                    } catch (IOException ex) {
                        closeSocket(socket);
                    }
                }
            }
        }).start();
    }
//    public void receiveMessageFromServer() {
//        while (socket.isConnected()) {
//            try {
//                System.out.println(inputFromServer.readUTF());
//            } catch (IOException ex) {
//                closeSocket(socket);
//            }
//        }
//    }
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
