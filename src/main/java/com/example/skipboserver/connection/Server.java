package com.example.skipboserver.connection;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private boolean online;
    private int port;
    private List<ClientHandler> clients;
    public Server(int port){
        this.port = port;
    }
    public void start() throws IOException {
        try {
            server = new ServerSocket(port);
            online = true;
            System.out.println("Server started on port " + port);

            while(online){
                socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostName());
                ClientHandler clientHandler = new ClientHandler(socket, this);
                clients.add(clientHandler);
                clientHandler.start();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void stop() throws IOException {
        server.close();
        online = false;
    }

    public void broadcast(String message,ClientHandler sender){
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.send(message);
            }
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

}
