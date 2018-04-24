package ProjectOne;

public class Dealer {

    Hand hand;

    Dealer(){
        this.hand = new Hand();
    }

    public boolean draw(){

        return hand.getHandValue().count < 17;
    }
}