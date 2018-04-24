package ProjectOne;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {

    private List<Card> cards = new ArrayList<Card>();
    private List<Card> temp;

    GroupOfCards(){}

    void addCard(Card c) {
        cards.add(c);
    }


    void discardAll() {
        cards.clear();
    }


    int getCurrentSize() {
        return cards.size();
    }


    void display() {
        for (Card c : cards) {
            System.out.println(c.toString());
        }
    }

    Card deleteCard() {
        if (cards.size() == 0) {
            System.out.println("No card!");
            return null;
        }
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }

    Card getCard(int i) {
        return cards.get(i);
    }

    Card removeCardByIndex(int index) {

        if (cards.size() == 0) {
            System.out.println("No card!");
            return null;
        }

        if (index >= cards.size() || index < 0) {
            System.out.println("Index wrong!");
            return null;
        }

        Card c = cards.get(index);
        cards.remove(index);
        return c;
    }

    List<Card> copyDeck() {
        temp = new ArrayList<>(cards);
        return temp;
    }

    List<Card> pasteDeck() {
        cards = new ArrayList<>(temp);
        return cards;
    }
}
