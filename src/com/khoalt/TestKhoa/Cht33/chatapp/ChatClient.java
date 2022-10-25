package com.khoalt.TestKhoa.Cht33.chatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private DataOutputStream toServer;
    private DataInputStream fromServer;
    private Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        new ChatClient();
    }
    public ChatClient() {
        try {
            Socket socket = new Socket("localhost", 1234);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());
            String name, message;
            while (true) {
                System.out.println("Enter your name: ");
                name = input.nextLine();
                toServer.writeUTF(name);
                while (true) {
                    message = input.nextLine();
                    toServer.writeUTF(message);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
