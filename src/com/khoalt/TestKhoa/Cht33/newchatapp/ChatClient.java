package com.khoalt.TestKhoa.Cht33.newchatapp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private Socket socket;
    private BufferedReader inputFromServer;
    private BufferedWriter outputToServer;
    private String clientName;
    public ChatClient(Socket socket, String clientName) {
        try {
            this.socket = socket;
            this.inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.outputToServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientName = clientName;
            outputToServer.write(clientName);
            outputToServer.flush();
        } catch (IOException ex) {
            closeSocket(socket, inputFromServer, outputToServer);
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        ChatClient client = new ChatClient(socket, input.nextLine());
        client.receiveMessage();
        client.sendMessage();
    }
    public void sendMessage() {
        try {
            Scanner input = new Scanner(System.in);
            while (socket.isConnected()) {
                outputToServer.write(input.nextLine());
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
                while (socket.isConnected()) {
                    try {
                        System.out.println(inputFromServer.readLine());
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
