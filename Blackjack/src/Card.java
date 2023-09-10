public class Card {

     private Color color;
     private Rank rank;

    public Card(Color color, Rank rank){
        this.color = color;
        this.rank = rank;
    }

    public Card(Card card){
        this.color = card.getColor();
        this.rank = card.getRank();
    }

    public int getValue(){
        return rank.rankValue;
    }

    public Color getColor(){
        return color;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return (""+rank+" von "+ color + " ("+this.getValue()+")");

    }
}