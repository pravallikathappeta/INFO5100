package ProjectOne;

public class Trick {

    Player player;
    Dealer dealer;
    Deck deck;
    int bet;

    Trick(Player player, Dealer dealer, Deck deck) {

        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    void play() throws DeckEmptyExecption {

        wager();
        DealFour();
        playerTurn();
        dealerTurn();
        closeTurn();
    }

    void wager() {

        bet = player.bet();
        System.out.println( "Player bets " + bet);
    }

    void DealFour() throws DeckEmptyExecption {

        player.hand = new Hand();
        dealer = new Dealer();

        Card c = deck.deal();
        player.hand.addCard(c);
        player.expose(c);
        System.out.println("Player dealt " + c.toString());

        c = deck.deal();
        dealer.hand.addCard(c);
        player.expose(c);
        System.out.println("Dealer dealt " + c.toString());

        c = deck.deal();
        player.hand.addCard(c);
        player.expose(c);
        System.out.println("Player dealt " + c.toString());

        c = deck.deal();
        dealer.hand.addCard(c);
    }
    void playerTurn() throws DeckEmptyExecption {

        if (player.hand.getHandValue().count == 21 && player.hand.getHandValue().soft) {
            return;
        }

        while (player.draw(dealer.hand.getCard(0))) {

            Card curCard = deck.deal();
            player.hand.addCard(curCard);
            player.expose(curCard);
            System.out.println("Player dealt " + curCard.toString());
        }

        System.out.println("Player's total is " + player.hand.getHandValue().count);

        if (player.hand.getHandValue().count > 21) {
            player.bankroll -= bet;
            System.out.println("Player busts");
        }
    }

    void dealerTurn() throws DeckEmptyExecption {

        if (player.hand.getHandValue().count > 21 || player.hand.getHandValue().count == 21 && player.hand.getHandValue().soft) {
            return;
        }

        player.expose(dealer.hand.getCard(1));
        System.out.println("Dealer's hole card is " + dealer.hand.getCard(1));

        while (dealer.draw()) {
            Card curCard = deck.deal();
            dealer.hand.addCard(curCard);
            player.expose(curCard);
            System.out.println("Dealer dealt " + curCard.toString());
        }

        System.out.println("Dealer's total is " + dealer.hand.getHandValue().count);

        if (dealer.hand.getHandValue().count > 21) {
            player.bankroll += bet;
            System.out.println("Dealer busts");
        }
    }
    void closeTurn() {

        if (player.hand.getHandValue().count == 21 && player.hand.getHandValue().soft) {
            player.bankroll += (int)(1.5 * bet);
            System.out.println("Player dealt natural 21");
            return;
        }

        if (player.hand.getHandValue().count > 21) {
            return;
        }

        if (dealer.hand.getHandValue().count > 21) {
            return;
        }

        if (player.hand.getHandValue().count < dealer.hand.getHandValue().count) {
            player.bankroll -= bet;
            System.out.println("Dealer wins");
        } else if (player.hand.getHandValue().count > dealer.hand.getHandValue().count) {
            player.bankroll += bet;
            System.out.println("Player wins");
        } else {
            System.out.println("Push");
        }
    }
}