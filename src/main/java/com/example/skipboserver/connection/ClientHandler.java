package com.example.skipboserver.connection;

import com.example.skipboserver.management.Game;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

public class ClientHandler extends Thread{
    private Socket socket;
    private final MessageCreator messageCreator;
    private Server server;

    private BufferedReader input;
    private PrintWriter output;
    public ClientHandler(Socket socket,Server server){
        this.socket = socket;
        this.server = server;
        this.messageCreator = MessageCreator.getInstance();
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
                JSONObject jsonObject = new JSONObject(input);
                receivedMessage(jsonObject);
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

    private void receivedMessage(JSONObject message) {
        String key = getKey(message);
        HashMap<String, Class<?>> keyTypes = new HashMap<String, Class<?>>();
        switch(key){
            //logs the player in
            case "login":
                //JSONObject responseMessage = messageCreator.createResponseMessage("login", false, ErrorCode.LOGIN_NOT_PERMITTED);
                //send(responseMessage);
                break;
            //player joins the game
            case "joinGame":
                break;
            //player makes move from Hand, playerPile or personal pile to buildup pile
            case "makeMove":
                break;
            //player ends move by depositing a hand card onto a personal pile
            case "endMove":
                break;
            //player makes inquiry of drawing card to their hand
            case "drawCard":
                break;
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

    public static String getKey(JSONObject message){
        Set<String> keys = message.keySet();

        if(keys.size() != 1){
            return null;
        }

        return keys.iterator().next();
    }


}
