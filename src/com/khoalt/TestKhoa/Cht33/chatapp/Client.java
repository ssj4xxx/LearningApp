package com.khoalt.TestKhoa.Cht33.chatapp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket;
    BufferedReader clientReader;
    BufferedWriter clientWriter;
    String username;

    public Client(Socket socket, String username) {
        try {
            this.username = username;
            this.socket = socket;
            clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clientWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner input = new Scanner(System.in);
                while (socket.isConnected()) {
                    try {
                        clientWriter.write(input.nextLine());
                        clientWriter.newLine();
                        clientWriter.flush();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void receiveMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        System.out.println(clientReader.readLine());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void sendNameToServer() {
        try {
            clientWriter.write(this.username);
            clientWriter.newLine();
            clientWriter.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
