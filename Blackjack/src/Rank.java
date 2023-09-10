public enum Rank {
    ACE("Ace", 11),
    ZWEI("Zwei", 2),
    DREI("Drei", 3),
    VIER("Vier",4),
    FÜNF("Fünf",5),
    SECHS("Secjs",6),
    SIEBEN("Sieben",7),
    ACHT("Acht",8),
    NEUN("Neun",9),
    ZEHN("Zehn",10),
    BUBE("Bube",10),
    DAME("Dame",10),
    KÖNIG("König",10);

    String rankName;
    int rankValue;

    Rank(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    public String toString(){
        return rankName;
    }
}