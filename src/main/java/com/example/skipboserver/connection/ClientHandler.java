package com.example.skipboserver.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket socket;
    private Server server;

    private BufferedReader input;
    private PrintWriter output;
    public ClientHandler(Socket socket,Server server){
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String message = input.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("Received message from client: " + message);
                server.broadcast(message, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.removeClient(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void start() {
        System.out.println("Starting client handler thread.");
        super.start();
    }

    public void send(String message) {
        output.println(message);
    }
}
