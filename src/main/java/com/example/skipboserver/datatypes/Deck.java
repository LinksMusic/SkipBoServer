package com.example.skipboserver.datatypes;

import com.example.skipboserver.datatypes.enums.Color;
import com.example.skipboserver.datatypes.enums.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck;
    public Deck(){
        deck = new Stack<>();
    }

    public Deck(Card[] cards){
        deck = new Stack<>();
        for (int i = cards.length - 1; i >= 0; i--) {
            deck.push(cards[i]);
        }
    }

    public void initializeDeck(){
        for(Value v: Value.values()) {
            Color color = switch (v) {
                case ONE, TWO, THREE, FOUR -> Color.BLUE;
                case FIVE, SIX, SEVEN, EIGHT -> Color.GREEN;
                case NINE, TEN, ELEVEN, TWELVE -> Color.RED;
                default -> null;
            };
            for(int i = 0;i<12;i++){
                deck.push(new Card(v, color));
            }
        }
        for(int j=0;j<=18;j++){
            deck.push(new Card(Value.JOKER,null));
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public Card drawCard(){
        return deck.pop();
    }

    public void addCard(Card card){
        deck.push(card);
    }

    public int size(){
        return this.deck.size();
    }
}
