package com.example.skipboserver.management;

import com.example.skipboserver.datatypes.Card;
import com.example.skipboserver.datatypes.Deck;
import com.example.skipboserver.datatypes.Gamestate;
import com.example.skipboserver.datatypes.Player;
import com.example.skipboserver.datatypes.enums.Phase;
import com.example.skipboserver.datatypes.enums.Pile;
import com.example.skipboserver.datatypes.enums.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Gameboard {
    private final Deck drawPile;
    private HashMap<Pile,Stack<Card>> buildUpPiles;
    private Stack<Card> buildUpPileOne;
    private Stack<Card> buildUpPileTwo;
    private Stack<Card> buildUpPileThree;
    private Stack<Card> buildUpPileFour;
    public Gameboard(){
        drawPile = new Deck();
        drawPile.initializeDeck();
        drawPile.shuffleDeck();
        buildUpPiles.put(Pile.ONE,buildUpPileOne);
        buildUpPiles.put(Pile.TWO,buildUpPileTwo);
        buildUpPiles.put(Pile.THREE,buildUpPileThree);
        buildUpPiles.put(Pile.FOUR,buildUpPileFour);
    }



    public void distributeDeckCards(Player player){
        Card[] cards = new Card[30];
        Deck personalDeck;
        for(int i=0;i<=29;i++) {
            cards[i] = drawPile.drawCard();
        }
        personalDeck = new Deck(cards);
        player.setPersonalDeck(personalDeck);
    }

    /**
     * Adds a card from a player to the BuildUpPile
     * @param player Player to make the move
     * @param pileNr BuildupPile to move the card to
     * @param card Card from either Hand or PlayerDeck
     */
    public boolean addCardToBuildupPile(Player player, Pile pileNr, Card card){
        if (validCardMove(pileNr, card)) {
            buildUpPiles.get(pileNr).push(player.getCardFromHand(card));
            return true;
        } else {
            player.addCardToHand(card);
            return false;
        }
    }

    public boolean addCardToBuildupPile(Player player, Pile pileNr, Pile playerDeck){
        Card card = player.getCardFromPlayerDeck(playerDeck);
        if(validCardMove(pileNr,card)){
            buildUpPiles.get(pileNr).push(player.getCardFromPlayerDeck(pileNr));
            return true;
        }
        else {
            player.addCardToPlayerDeck(playerDeck, card);
            return false;
        }
    }

    public boolean addCardToBuildupPile(Player player, Pile pileNr){
        Card card = player.getCardFromPersonalDeck();
        if(validCardMove(pileNr,card)){
            buildUpPiles.get(pileNr).push(card);
            return true;
        }
        else {
            //revert changes if unsuccessful
            player.addCardToPersonalDeck(card);
            return false;
        }
    }

    /**
     * checks if the provided Card is valid to move onto BuildupPile
     * @param pileNr Number of BuildupPile
     * @param card either Hand or PlayerDeck
     * @return true if move is valid, else false
     */
    private boolean validCardMove(Pile pileNr,Card card) {
        HashMap<Pile,Stack<Card>> dict = new HashMap<>();
        dict.put(Pile.ONE,buildUpPileOne);
        dict.put(Pile.TWO,buildUpPileTwo);
        dict.put(Pile.THREE,buildUpPileThree);
        dict.put(Pile.FOUR,buildUpPileFour);
        if(card.getValue() == Value.JOKER){
            return true;
        }else if(dict.get(pileNr).size()==0 && card.getValue() != Value.ONE){
            return false;
        } else return card.getValue().getValue() - dict.get(pileNr).peek().getValue().getValue() == 1;
    }

    public boolean gameOver(Player player){
        return player.getPersonalDeckLength() == 0;
    }

    public void addCardToPlayerDeck(Player player, Pile pileNr, Card card){
        player.addCardToPlayerDeck(pileNr,player.getCardFromHand(card));
    }

    public ArrayList<Card> addCardToPlayerHand(Player player){
        ArrayList<Card> out = new ArrayList<Card>();
        Card card;
        while(player.getHandLength() != 5){
            card = drawPile.drawCard();
            out.add(card);
            player.addCardToHand(card);
        }
        return out;
    }


}
