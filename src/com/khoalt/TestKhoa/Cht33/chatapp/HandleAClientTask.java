package com.khoalt.TestKhoa.Cht33.chatapp;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandleAClientTask implements Runnable {
    private Socket socket;
    private static List<HandleAClientTask> allTasks = Collections.synchronizedList(new ArrayList<>());
    public HandleAClientTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
