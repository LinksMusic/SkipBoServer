package com.example.skipboserver.management;

import com.example.skipboserver.datatypes.Card;
import com.example.skipboserver.datatypes.Gamestate;
import com.example.skipboserver.datatypes.Player;
import com.example.skipboserver.datatypes.enums.Phase;
import com.example.skipboserver.datatypes.enums.Pile;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Game {
    private Queue<Player> playerQueue;
    private Gameboard gameboard;
    private Gamestate gamestate;

    public Game(){
        gameboard = new Gameboard();
        for(Player p: playerQueue){
            gameboard.distributeDeckCards(p);
        }
    }

    public void joinGame(Player player){
        playerQueue.add(player);
    }

    public void makeMove(String origin,Player player, Card fromHand,Pile fromPlayerDeck, Pile pileNr){
        switch(origin){
            case "Hand":
                if(gameboard.addCardToBuildupPile(player,pileNr,fromHand)){
                    gamestate.setFromHand(fromHand);
                    gamestate.setFromPlayerDeck(null);
                }
            case "PlayerDeck":
                if(gameboard.addCardToBuildupPile(player,pileNr,fromPlayerDeck)){
                    gamestate.setFromHand(null);
                    gamestate.setFromPlayerDeck(fromPlayerDeck);
                }
            case "PersonalDeck":
                if(gameboard.addCardToBuildupPile(player,pileNr)){
                    gamestate.setFromHand(null);
                    gamestate.setFromPlayerDeck(null);
                }
        }

        gamestate.setMove(Phase.MAKEMOVE);
        gamestate.setPlayer(playerQueue);
        gamestate.setTo(pileNr);
        if(gameboard.gameOver(player)){
            gamestate.setWinner(player);
        }
        else{
            gamestate.setWinner(null);
        }
        gamestate.setOrigin(origin);
    }

    public void endMove(Player player,Card fromHand,Pile pileNr){
        gameboard.addCardToPlayerDeck(player,pileNr,fromHand);
        gamestate.setMove(Phase.ENDMOVE);
        gamestate.setTo(pileNr);
        gamestate.setOrigin("Hand");
        gamestate.setFromPlayerDeck(null);
        gamestate.setFromHand(fromHand);
        if(gameboard.gameOver(player)){
            gamestate.setWinner(player);
            gamestate.setPlayer(playerQueue);
        }
        else{
            gamestate.setWinner(null);
            Player first = playerQueue.remove();
            playerQueue.add(first);
            gamestate.setPlayer(playerQueue);
        }
    }

    public ArrayList<Card> drawCard(Player player){
        return gameboard.addCardToPlayerHand(player);
    }

    public Gamestate getGamestate() {
        return gamestate;
    }

    public void setGamestate(Gamestate gamestate) {
        this.gamestate = gamestate;
    }

    public void addPlayer(Player player){
        playerQueue.add(player);
    }

}
