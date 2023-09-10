import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cardDeck;

    public Deck(){
       cardDeck = new ArrayList<Card>();
    }

    public Deck(boolean makeDeck){
        cardDeck = new ArrayList<Card>();
        if(makeDeck){
            for(Color color : Color.values()){
                for(Rank rank : Rank.values()){
                    cardDeck.add(new Card(color, rank));
                }
            }
        }
    }

    public void addCard(Card card){
        cardDeck.add(card);
    }

    public void addCards(ArrayList<Card> cards){
        cardDeck.addAll(cards);
    }

    public String toString(){
        String output = "";

        for(Card card: cardDeck){
            output += card;
            output += "\n";
        }
        return output;
    }

    public void shuffle(){
        Collections.shuffle(cardDeck, new Random());
    }

    public Card takeCard(){
        Card cardToTake = cardDeck.get(0);
        cardDeck.remove(0);
        return cardToTake;
    }

    public boolean hasCards(){
        if (cardDeck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public int cardsLeft(){
        return cardDeck.size();
    }

    public ArrayList<Card> getCards() {
        return cardDeck;
    }


    public void emptyDeck(){
        cardDeck.clear();
    }

    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Keine Karten mehr übrig. Neuer Stapel wird aus Ablagestampel gemischt.");
    }


}