public enum Color {
    KREUZ("Kreuz"),
    KARO("Karo"),
    HERZ("Herz"),
    PIK("Spades");

    String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }

    public String toString(){
        return colorName;
    }
}