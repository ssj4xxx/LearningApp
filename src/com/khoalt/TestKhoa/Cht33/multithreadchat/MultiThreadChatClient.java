package com.khoalt.TestKhoa.Cht33.multithreadchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiThreadChatClient {
    Socket socket;
    private DataInputStream inputFromServer;
    private DataOutputStream outputToServer;
    String username;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        MultiThreadChatClient client = new MultiThreadChatClient(socket);
        client.receiveMessageFromServer();
        client.sendMessageToServer();
    }
    public MultiThreadChatClient(Socket socket) {
        try {
            this.socket = socket;
            Scanner input = new Scanner(System.in);
            inputFromServer = new DataInputStream(socket.getInputStream());
            outputToServer = new DataOutputStream(socket.getOutputStream());
            System.out.print("Enter your name: ");
            username = input.nextLine();
            outputToServer.writeUTF(username);
            outputToServer.flush();
        } catch (IOException ex) {
            closeSocket(socket);
        }
    }
    public void sendMessageToServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Scanner input = new Scanner(System.in);
                    while (socket.isConnected()) {
                        outputToServer.writeUTF(input.nextLine());
                        outputToServer.flush();
                    }
                } catch (IOException ex) {
                    closeSocket(socket);
                }
            }
        }).start();
    }
    public void receiveMessageFromServer() {
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
