package com.khoalt.TestKhoa.Cht33.multithreadchat;

import java.io.*;
import java.net.Socket;

public class Client {
    private String username;
    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedReader createReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    public BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void closeSocket() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isConnected(){
        return this.socket.isConnected();
    }
}
