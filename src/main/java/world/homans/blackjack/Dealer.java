package world.homans.blackjack;

/**
 * Dealer class.
 */
public class Dealer extends Cardholder {

    public void hitTillSeventeen(Deck deck) {
        while (getTotalPoints() < 17) {
            takeCard(deck);
        }
    }
}
