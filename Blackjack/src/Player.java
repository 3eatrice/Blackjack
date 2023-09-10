import java.util.Scanner;

public class Player extends Person {

    Scanner input = new Scanner(System.in);

    private int money = 100;
    private int currentBet = 0; // Aktueller Einsatz

    // Erstellt neuen Spieler
    public Player() {
        super.setName("Du");
    }

    public void makeDecision(Deck cardDeck, Deck discard) {
        String decision = "";
        boolean getDecision = true;

        while (getDecision) {
            try {
                System.out.println("Willst du eine neue Karte ziehen und dein Deck behalten? Schreibe Hit oder Stand");
                decision = input.nextLine().toLowerCase();
                getDecision = false;
            } catch (Exception e) {
                System.out.println("Falsche Eingabe.");
                input.next();
            }
        }

        if (decision.equals("hit")) {
            this.hit(cardDeck, discard);
            if (this.getHand().calculatedValue() > 20) {
                // Hier den Einsatz bei Verlust abziehen
                int currentMoney = this.getMoney();
                int currentBet = this.getCurrentBet();
                this.setMoney(currentMoney - currentBet);
                return;
            } else {
                this.makeDecision(cardDeck, discard);
            }
        } else {
            System.out.println("Du behältst dein Deck.");
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public Scanner getInput() {
        return input;
    }
}
