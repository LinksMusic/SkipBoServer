package com.example.skipboserver.datatypes;

import java.util.ArrayList;

public class Gameboard {
    private final Deck drawPile;
    private ArrayList<Card> buildUpPileOne;

    private ArrayList<Card> buildUpPileTwo;
    private ArrayList<Card> buildUpPileThree;
    private ArrayList<Card> buildUpPileFour;
    public Gameboard(){
        drawPile = new Deck();
        drawPile.initializeDeck();
        drawPile.shuffleDeck();
    }

    public void distributeDeckCards(Player player){
        Card card;
        for(int i=0;i<=29;i++) {
            card = drawPile.drawCard();
            player.addCardToPersonalDeck(card);
        }
    }

    public void addCardToBuildUpPile(Player player,int pileNr, Card card){
        switch(pileNr){
            case 1:
                buildUpPileOne.add(player.getCardFromHand());
        }
    }
}
