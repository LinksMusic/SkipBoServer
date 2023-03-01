package com.example.skipboserver.datatypes;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> personalDeck;
    private ArrayList<Card> hand;
    private ArrayList<Card> playerDeckOne;
    private ArrayList<Card> playerDeckTwo;
    private ArrayList<Card> playerDeckThree;
    private ArrayList<Card> playerDeckFour;
    private String name;
    public Player(String name){
        this.name = name;
    }

    public void addCardToPlayerDeck(int deckNr, Card card){
        switch (deckNr) {
            case 1 -> playerDeckOne.add(card);
            case 2 -> playerDeckTwo.add(card);
            case 3 -> playerDeckThree.add(card);
            case 4 -> playerDeckFour.add(card);
            default -> System.out.println("Insufficient Player Deck");
        }
    }

    public Card getCardFromPlayerDeck(int deckNr){
        Card card;
        switch (deckNr) {
            case 1 -> {
                card = playerDeckOne.get(0);
                playerDeckOne.remove(card);
            }
            case 2 -> {
                card = playerDeckTwo.get(0);
                playerDeckTwo.remove(card);
            }
            case 3 -> {
                card = playerDeckThree.get(0);
                playerDeckThree.remove(card);
            }
            case 4 -> {
                card = playerDeckFour.get(0);
                playerDeckFour.remove(card);
            }
            default -> {
                System.out.println("Insufficient Player Deck");
                card = null;
            }
        }
        return card;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }
    public Card getCardFromHand(){
        Card card = hand.get(0);
        hand.remove(card);
        return card;
    }

    public void addCardToPersonalDeck(Card card){
        personalDeck.add(card);
    }

    public Card getCardFromPersonalDeck(){
        Card card = personalDeck.get(0);
        personalDeck.remove(card);
        return card;
    }

}
