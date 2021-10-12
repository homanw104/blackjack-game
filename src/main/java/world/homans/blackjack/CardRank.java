package world.homans.blackjack;

/**
 * Enumeration class containing 13 card ranks.
 */
public enum CardRank {
    ACE     (" A"),
    TWO     (" 2"),
    THREE   (" 3"),
    FOUR    (" 4"),
    FIVE    (" 5"),
    SIX     (" 6"),
    SEVEN   (" 7"),
    EIGHT   (" 8"),
    NINE    (" 9"),
    TEN     ("10"),
    JACK    (" J"),
    QUEEN   (" Q"),
    KING    (" K");

    private final String displayChar;

    CardRank(String displayChar) {
        this.displayChar = displayChar;
    }

    @Override
    public String toString() {
        return displayChar;
    }
}
