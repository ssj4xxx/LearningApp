package com.khoalt.TestKhoa.Cht33.chatapp;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//TODO: remove task khi client quit
//TODO: remove client

public class HandleAClientTask implements Runnable {
    private Socket socket;
    private BufferedReader serverReader;
    private BufferedWriter serverWriter;
    String taskClientName;
    private static List<HandleAClientTask> allTasks = Collections.synchronizedList(new ArrayList<>());
    public HandleAClientTask(Socket socket) {
        try {
            this.socket = socket;
            this.serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.serverWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.taskClientName = serverReader.readLine();
            allTasks.add(this);
        } catch (IOException ex) {
            ex.printStackTrace();
            closeSocket();
        }
    }
    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                String messageFromAClient = serverReader.readLine();
                broadcastToAll(messageFromAClient);
            } catch (Exception ex) {
                closeSocket();
                broadcastToAll("has left the chat");
            }
        }
    }
    public void broadcastToAll(String message) {
        for (HandleAClientTask task : allTasks) {
            try {
                if (!task.taskClientName.equals(taskClientName)) {
                    task.serverWriter.write(taskClientName + ": " + message);
                    task.serverWriter.newLine();
                    task.serverWriter.flush();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Cannot print message");
                closeSocket();
            }
        }
    }
    public void closeSocket() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                serverReader.close();
                serverWriter.close();
                System.out.println(this.taskClientName + " has disconnected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
