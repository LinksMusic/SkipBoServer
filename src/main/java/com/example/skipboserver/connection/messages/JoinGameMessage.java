package com.example.skipboserver.connection.messages;

import com.example.skipboserver.connection.Message;

public class JoinGameMessage extends Message {
    public JoinGameMessage(){
        type = "joinGame";
    }
}
