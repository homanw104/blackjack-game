package world.homans.blackjack;

import java.util.ArrayList;

public class Cardholder {

    /**
     * A cardholder has several cards in hand.
     */
    private final ArrayList<Card> hand;

    /**
     * A cardholder holds no card by default.
     */
    public Cardholder() {
        hand = new ArrayList<>();
    }

    /**
     * Take a card from top of deck.
     * @param deck a deck with one or more cards in it
     */
    public void takeCard(Deck deck) {
        Card card = deck.drawCardFromTop();
        if (card != null) {
            hand.add(card);
        }
    }

    /**
     * Calculate total points in the hand.
     * @return the biggest points possible under 21. If it's impossible, return the smallest points.
     */
    public int calculateTotalPoints() {
        int points = 0;
        int aceCount = 0;
        for (Card card : hand) {
            points += card.getPoints();
            if (card.getRank() == CardRank.ACE) aceCount++;
        }
        while (aceCount-- > 0) {
            if (points > 21) points -= 10;
        }
        return points;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
