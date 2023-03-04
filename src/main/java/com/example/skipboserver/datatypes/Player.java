package com.example.skipboserver.datatypes;

import com.example.skipboserver.datatypes.enums.Pile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Represents a Player with a name, a hand of Cards, a personal deck and four temporary discard piles
 */

public class Player {
    private Deck personalDeck;
    private ArrayList<Card> hand;
    private Stack<Card> playerDeckOne;
    private Stack<Card> playerDeckTwo;
    private Stack<Card> playerDeckThree;
    private Stack<Card> playerDeckFour;
    private String name;
    public Player(String name){
        this.name = name;
        playerDeckOne = new Stack<>();
        playerDeckTwo = new Stack<>();
        playerDeckThree = new Stack<>();
        playerDeckFour = new Stack<>();
    }

    /**
     * Adds a card to the corresponding deposit deck
     * @param deckNr number from 1 to 4 of the corresponding deposit deck
     * @param card card that is deposited
     */
    public void addCardToPlayerDeck(Pile deckNr, Card card){
        switch (deckNr) {
            case ONE -> playerDeckOne.push(card);
            case TWO -> playerDeckTwo.push(card);
            case THREE -> playerDeckThree.push(card);
            case FOUR -> playerDeckFour.push(card);
            default -> throw new IllegalArgumentException("Invalid deck number");
        }
    }

    /**
     * gets card from the deposit deck
     * @param deckNr number from 1 to 4 of the corresponding deposit deck
     * @return Card sitting on top of the deposit deck
     */
    public Card getCardFromPlayerDeck(Pile deckNr){
        Card card;
        switch (deckNr) {
            case ONE -> card = playerDeckOne.pop();
            case TWO -> card = playerDeckTwo.pop();
            case THREE -> card = playerDeckThree.pop();
            case FOUR -> card = playerDeckFour.pop();
            default -> throw new IllegalArgumentException("Invalid deck number");
        }
        return card;
    }

    public Stack<Card> getPlayerDeck(Pile deckNr){
        Card card;
        switch (deckNr) {
            case ONE -> {
                return playerDeckOne;
            }
            case TWO -> {
                return playerDeckTwo;
            }
            case THREE -> {
                return playerDeckThree;
            }
            case FOUR -> {
                return playerDeckFour;
            }
            default -> throw new IllegalArgumentException("Invalid deck number");
        }
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public Card getCardFromHand(Card pCard){
        Card card = hand.get(hand.indexOf(pCard));
        hand.remove(card);
        return card;
    }

    public void setPersonalDeck(Deck personalDeck) {
        this.personalDeck = personalDeck;
    }

    public Card getCardFromPersonalDeck(){
        return personalDeck.drawCard();
    }

    public int getPersonalDeckLength(){
       return personalDeck.size();
    }

}
