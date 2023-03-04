package com.example.skipboserver.datatypes;

import com.example.skipboserver.datatypes.enums.Phase;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Stack;

public class Gamestate {
    private Player currentPlayer;
    private Phase currentPhase;
    private boolean isOver;
    private Card from;
    private Stack<Card> to;
    public Gamestate(Player player,Phase phase, boolean isOver,Card from, Stack<Card> to){
        this.currentPlayer = player;
        this.currentPhase = phase;
        this.isOver = isOver;
        this.from = from;
        this.to = to;
    }





}
