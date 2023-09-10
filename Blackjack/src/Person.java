public abstract class Person {

    private Hand hand;
    private String name;

    public Person(){
        this.hand = new Hand();
        this.name = "";
    }


    //Setters & Getters
    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void printHand(){
        System.out.println(this.name + " hast folgende Karten:");
        System.out.println(this.hand + " mit diesem Wert: " + this.hand.calculatedValue());
    }

    public void hit(Deck deck, Deck discard){

        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " bekommt eine Karte");
        this.printHand();

    }

}