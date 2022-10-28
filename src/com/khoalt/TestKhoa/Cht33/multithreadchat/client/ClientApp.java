package com.khoalt.TestKhoa.Cht33.multithreadchat.client;

import java.io.IOException;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        ChatClient client = new ChatClient(socket);
        client.createReceiver();
        client.createSender();
    }
}
