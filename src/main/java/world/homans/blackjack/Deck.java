package world.homans.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of cards - 52 cards at most.
 * When initialized, the Deck is ordered from SPADE to DIAMOND, A to K.
 * You may want to call shuffle() before drawing a card.
 */
public class Deck {

    private ArrayList<Card> cards;

    /**
     * Initialize a new ordered 52-card deck.
     */
    public Deck() {
        this.reset();
    }

    /**
     * Reset the deck into a list of 52 unique & ordered cards.
     */
    public void reset() {
        cards = new ArrayList<>();
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffle all cards remained in the deck.
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * Return true if the Deck is empty.
     * @return True if empty, otherwise False.
     */
    public Boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Draw and return a card from top of the deck, card may be null.
     * @return Card from top of the deck.
     */
    public Card drawCardFromTop() {
        if (this.isEmpty()) {
            return null;
        } else {
            return cards.remove(0);
        }
    }
}
