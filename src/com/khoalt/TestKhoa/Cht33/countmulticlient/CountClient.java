package com.khoalt.TestKhoa.Cht33.countmulticlient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CountClient {
    private DataOutputStream toServer;
    private DataInputStream fromServer;
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new CountClient();
    }

    public CountClient() {
        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            System.out.println("You are visitor number " + fromServer.readInt());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
