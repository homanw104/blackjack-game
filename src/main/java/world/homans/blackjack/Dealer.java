package world.homans.blackjack;

/**
 * Dealer class.
 */
public class Dealer extends Cardholder {

    public void hitUntilSeventeen(Deck deck) {
        while (getTotalPoints() < 17) {
            takeCard(deck);
        }
    }
}
