package com.example.skipboserver.connection.messages;

import com.example.skipboserver.connection.Message;

public class LoginMessage extends Message {
    private String username;

    public LoginMessage() {
        type = "login";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
