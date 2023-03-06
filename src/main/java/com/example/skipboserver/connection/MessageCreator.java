package com.example.skipboserver.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageCreator {

    private static MessageCreator instance;
    private final Gson gson;

    private MessageCreator(){
        gson = new GsonBuilder().serializeNulls().create();
    }

    /**
     * This method returns the MessageCreator
     * @return the only instance of the MessageCreator
     */
    public static MessageCreator getInstance() {
        if(instance == null){
            instance = new MessageCreator();
        }
        return instance;
    }
}
