package com.khoalt.TestKhoa.Cht33.calculateradius;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private DataOutputStream toServer;
    private DataInputStream fromServer;
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            System.out.println("Nhap radius");
            double radius = input.nextDouble();
            toServer.writeDouble(radius);
            toServer.flush();
            double area = fromServer.readDouble();
            System.out.println("Area is: " + area);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
