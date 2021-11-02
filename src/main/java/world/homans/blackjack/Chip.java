package world.homans.blackjack;

/**
 * Chip used in bets. A chip holds a fixed value.
 */
public class Chip {

    private final int value;

    public Chip(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
