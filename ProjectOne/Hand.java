package ProjectOne;

public class Hand extends GroupOfCards{

    class HandValue {
        int count;
        boolean soft;
    }


    private HandValue curValue = new HandValue();

    Hand() {
        super();
        discardAll();
    }


    HandValue getHandValue() {

        int aces = 0;

        while (getCurrentSize() > 0){

            int cardValue = this.deleteCard().getSpot().getValue();

            if (cardValue == 1)
                aces++;

            curValue.count += cardValue;
        }

        if (aces != 0 && curValue.count <= 11) {
            curValue.count += 10;
            curValue.soft = true;
        }

        return curValue;
    }
}