package ProjectOne;

public abstract class Player {

    Hand hand;
    int bankroll;
    int minimum;

    Player(int bankroll, int minimum){
        this.bankroll = bankroll;
        this.minimum = minimum;
        this.hand = new Hand();
    }

    public abstract int bet();


    public boolean draw(Card dealer) {

        if (hand.getHandValue().soft == false) {

            if (hand.getHandValue().count <= 11) {

                return true;

            } else if (hand.getHandValue().count == 12) {

                return dealer.getSpot().getValue() < 4 || dealer.getSpot().getValue() > 6;

            } else if (hand.getHandValue().count >= 13 && hand.getHandValue().count <= 16) {

                return dealer.getSpot().getValue() < 2 || dealer.getSpot().getValue() > 6;

            } else {
                return false;
            }
        } else {

            if (hand.getHandValue().count <= 17) {
                return true;
            } else if (hand.getHandValue().count == 18) {

                return dealer.getSpot().getValue() != 2
                        && dealer.getSpot().getValue() != 7
                        && dealer.getSpot().getValue() != 8;
            } else {
                return false;
            }
        }
    }

    public abstract void expose(Card c);


    public abstract void shuffled();

}
