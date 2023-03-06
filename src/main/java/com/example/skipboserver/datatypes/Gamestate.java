package com.example.skipboserver.datatypes;

import com.example.skipboserver.connection.Message;
import com.example.skipboserver.datatypes.Card;
import com.example.skipboserver.datatypes.Player;
import com.example.skipboserver.datatypes.enums.Phase;
import com.example.skipboserver.datatypes.enums.Pile;

import java.util.Queue;
import java.util.Stack;

public class Gamestate {
    private Queue<Player> playerQueue;
    private Phase move;
    private String origin;
    private Card fromHand;
    private Pile fromPlayerDeck;
    private Pile to;
    private Player winner;
    public Gamestate(){
    }

    public Queue<Player> getPlayer() {
        return playerQueue;
    }

    public void setPlayer(Queue<Player> playerQueue) {
        this.playerQueue = playerQueue;
    }

    public Phase getMove() {
        return move;
    }

    public void setMove(Phase move) {
        this.move = move;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Card getFromHand() {
        return fromHand;
    }

    public void setFromHand(Card fromHand) {
        this.fromHand = fromHand;
    }

    public Pile getTo() {
        return to;
    }

    public void setTo(Pile to) {
        this.to = to;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Pile getFromPlayerDeck() {
        return fromPlayerDeck;
    }

    public void setFromPlayerDeck(Pile fromPlayerDeck) {
        this.fromPlayerDeck = fromPlayerDeck;
    }

}
