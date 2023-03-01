package com.example.skipboserver.datatypes;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    public Deck(){
        deck = new ArrayList<Card>();
    }

    public void initializeDeck(){
        for(Color c: Color.values()){
            for(int occurence=0;occurence<=3;occurence++){
                for(Value v: Value.values()){
                    if(v==Value.JOKER){
                        continue;
                    }else {
                        deck.add(new Card(v,c,false));
                    }
                }
            }
            for(int j=0;j<=6;j++){
                deck.add(new Card(Value.JOKER,c,false));
            }
        }

    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public Card drawCard(){
        Card c = deck.get(0);
        deck.remove(c);
        return c;
    }

}
