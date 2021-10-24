package world.homans.blackjack;

/**
 * A single playing card with a suit and a rank.
 */
public class Card {

    private final CardSuit suit;
    private final CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "[" + this.suit + " " + this.rank + "]";
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public int getPoints() {
        return rank.getPoints();
    }

    /**
     * The image url returned follows the organization of th resource folder.
     * Modify this method if resources change.
     * @return the image url of this card
     */
    public String getImageUrl() {
        String suitPrefix = suit.name().toLowerCase();
        String rankSuffix = String.valueOf(rank.ordinal() + 1);
        return "/img/" + suitPrefix + "_" + rankSuffix + ".png";
    }
}
