package com.example.skipboserver.datatypes;

import java.util.ArrayList;
import java.util.Stack;

public class Move {
    private Player player;
    private Card from;
    private Stack<Card> to;

    public Move(Player player, Card from, Stack<Card> to){
        this.player = player;
        this.from = from;
        this.to = to;
    }


}
