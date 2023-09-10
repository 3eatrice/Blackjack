import java.util.Scanner;

public class Game {

    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;

    public Game(){

        deck = new Deck(true);
        discarded = new Deck();

        dealer = new Dealer();
        player = new Player();

        deck.shuffle();
        startRound();
    }

    private void startRound(){
        if(wins>0 || losses>0 || pushes > 0){
            System.out.println();
            System.out.println("Starte nächste Runde... Siege: " + wins + " Niederlage: "+ losses+ " Unentschieden: "+pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        setBet(player);

        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();

        player.printHand();

        // Blackjack Abfrage für Dealer und Player
        boolean dealerHasBlackjack = dealer.getHand().calculatedValue() == 21;
        boolean playerHasBlackjack = player.getHand().calculatedValue() == 21;
    
        if (dealerHasBlackjack || playerHasBlackjack) {
            dealer.printHand();
    
            if (dealerHasBlackjack && playerHasBlackjack) {
                System.out.println("Ihr beide habt 21 - Unentschieden.");
                pushes++;
            }
            else if (dealerHasBlackjack) {
                System.out.println("Dealer hat Blackjack. Du hast verloren.");
                dealer.printHand();
                losses++;
            }
            else {
                System.out.println("Du hast Blackjack!");
                wins++;
            }
    
            startRound();
        }

        player.makeDecision(deck, discarded);

        if(player.getHand().calculatedValue() > 21){
            System.out.println("Du bist über 21 gekommen. Du hast verloren.");
            losses ++;
            startRound();
        }

        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer hat verloren.");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("Du hast verloren.");
            losses++;
        }
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("Du hast gewonnen.");
            wins++;
        }
        else{
            System.out.println("Unentschieden.");
        }

        startRound();
    }

    private void setBet(Player player) {
        int currentMoney = player.getMoney();
        Scanner input = player.getInput();

        boolean validBet = false;

        while (!validBet) {
            try {
                System.out.println("Dein aktuelles Geld: " + currentMoney);
                System.out.print("Wie viel möchtest du setzen? ");
                int bet = input.nextInt();
                input.nextLine();

                if (bet > 0 && bet <= currentMoney) {
                    player.setCurrentBet(bet);
                    validBet = true;
                } else {
                    System.out.println("Ungültiger Einsatz. Bitte versuche es erneut.");
                }
            } catch (Exception e) {
                System.out.println("Falsche Eingabe.");
                input.next();
            }
        }
    }
}
