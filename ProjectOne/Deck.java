package ProjectOne;


class DeckEmptyExecption extends Exception { // An exception type

    @Override
    public String toString() {
        return "The deck is empty!";
    }
}


public class Deck extends GroupOfCards {

    final int DeckSize = 52;



    Deck() {
        super();
        reset();
    }


    void reset() {

        discardAll();
        for (Suit suit : Suit.values()) {

            for (Spot spot : Spot.values()) {

                this.addCard(new Card(spot, suit));
            }
        }
    }


    void shuffleOnce(int n) {

        if (this.getCurrentSize() < 52) {
            this.pasteDeck();
        }

        if (n < 0 || n > DeckSize)
            return;

        int remain = Math.abs(DeckSize - n * 2);

        if (n <= DeckSize / 2) {

            for (int i = n; i > 0; i--) {

                addCard(removeCardByIndex(i));
                addCard(deleteCard());
            }

        } else {

            for (int i = n; i > remain; i--) {

                addCard(removeCardByIndex(i));
                addCard(deleteCard());
            }
        }

        for (int i = remain; i > 0; i--) {

            addCard(deleteCard());
        }

        copyDeck();
    }

    void shuffle(int times) {

        System.out.println("Shuffling the deck");
        int i = 0;
        while (i < times) {
            int r = (int)(13 + Math.random() * (39 - 13 + 1));
            System.out.println("cut at " + r);
            shuffleOnce(r);
            i++;
        }
    }


    Card deal() throws DeckEmptyExecption {

        if (getCurrentSize() == 0) {
            reset();
            throw new DeckEmptyExecption();
        } else {
            return this.deleteCard();
        }
    }

    int cardsLeft() {
        return this.getCurrentSize();
    }
}