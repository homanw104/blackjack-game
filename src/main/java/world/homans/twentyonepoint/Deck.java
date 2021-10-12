package world.homans.twentyonepoint;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of cards - 52 cards at most.
 */
public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        resetDeck();
    }

    /**
     * Reset the deck into a list of 52 unique & ordered cards.
     */
    public void resetDeck() {
        cards = new ArrayList<>();
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffle all cards in the deck.
     */
    public void shuffleDeck() {
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
     * Draw and return a card from top of the deck.
     * @return Card from top of the deck, or null if the deck is empty.
     */
    public @Nullable Card drawCardFromTop() {
        if (this.isEmpty()) {
            return null;
        } else {
            return cards.remove(0);
        }
    }
}
