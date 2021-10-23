package world.homans.blackjack;

/**
 * Dealer class.
 */
public class Dealer extends CardHolder{

    public void hitTillSeventeen(Deck deck) {
        while (calculateTotalPoints() < 17) {
            takeCard(deck);
        }
    }
}
