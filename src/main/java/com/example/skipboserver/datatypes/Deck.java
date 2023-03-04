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
        for(Color c: Color.values()){
            for(int occurence=0;occurence<=3;occurence++){
                for(Value v: Value.values()){
                    if(v==Value.JOKER){
                        continue;
                    }else {
                        deck.push(new Card(v,c,false));
                    }
                }
            }
            for(int j=0;j<=6;j++){
                deck.push(new Card(Value.JOKER,null,false));
            }
        }

    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public Card drawCard(){
        return deck.pop();
    }

    public int size(){
        return this.deck.size();
    }
}
