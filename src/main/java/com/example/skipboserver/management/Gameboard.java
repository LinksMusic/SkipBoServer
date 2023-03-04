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
import java.util.Stack;

public class Gameboard {
    private final Deck drawPile;
    private Stack<Card> buildUpPileOne;
    private Stack<Card> buildUpPileTwo;
    private Stack<Card> buildUpPileThree;
    private Stack<Card> buildUpPileFour;
    private Gamestate gamestate;
    public Gameboard(){
        drawPile = new Deck();
        drawPile.initializeDeck();
        drawPile.shuffleDeck();
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
    public void addCardToBuildUpPile(Player player, Pile pileNr, Card card){
        if(validCardMove(pileNr,card)){
            switch(pileNr){
                case ONE:
                    buildUpPileOne.push(player.getCardFromHand(card));
                case TWO:
                    buildUpPileTwo.push(player.getCardFromHand(card));
                case THREE:
                    buildUpPileThree.push(player.getCardFromHand(card));
                case FOUR:
                    buildUpPileFour.push(player.getCardFromHand(card));
                default:
                    throw new IllegalArgumentException("Invalid deck number");
            }
        }
        gamestate = new Gamestate(player, Phase.MAKEMOVE, false,card,switch(pileNr){
            case ONE -> buildUpPileFour;
            case TWO -> buildUpPileTwo;
            case THREE -> buildUpPileThree;
            case FOUR -> buildUpPileFour;
        });
    }

    /**
     * checks if the provided Card is valid to move onto BuildupPile
     * @param pileNr Number of BuildupPile
     * @param card either Hand or PlayerDeck
     * @return true if move is valid, else false
     */
    public boolean validCardMove(Pile pileNr,Card card) {
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

    public void addCardToPlayerDeck(Player player, Pile pileNr, Card card){
        player.addCardToPlayerDeck(pileNr,player.getCardFromHand(card));
        gamestate = new Gamestate(player,Phase.ENDMOVE,player.getPersonalDeckLength() == 0,card,player.getPlayerDeck(pileNr));
    }

    public void addCardToPlayerHand(Player player, Card card){
        player.addCardToHand(player.getCardFromPersonalDeck());
    }
}
