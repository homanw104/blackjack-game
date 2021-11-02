package world.homans.blackjack;

/**
 * Dealer class.
 */
public class Dealer extends Cardholder {

    /**
     * Hit the deck until the total point in hand reach 17.
     * @param deck deck which dealer hit
     */
    public void hitUntilSeventeen(Deck deck) {
        while (getTotalPoints() < 17) {
            takeCard(deck);
        }
    }
}
