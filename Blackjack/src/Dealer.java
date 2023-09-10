public class Dealer extends Person{


    public Dealer(){
        super.setName("Dealer");
    }

    public void printFirstHand(){
        System.out.println("Dealers Hand schaut so aus:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("Die 2. Karte wird nicht gezeigt.");
    }

}