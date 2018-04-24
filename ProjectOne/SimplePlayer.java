package ProjectOne;

public class SimplePlayer extends Player {
    SimplePlayer(int bankroll, int minimum){
        super(bankroll, minimum);
    }

    @Override
    public int bet() {

        if (bankroll < minimum) {
            throw new RuntimeException();
        }
        return minimum;
    }

    @Override
    public void expose(Card c) {}

    @Override
    public void shuffled() {}
}