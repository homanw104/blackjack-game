package world.homans.twentyonepoint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @ParameterizedTest
    @CsvSource({
            "0,[♠  A]",
            "9,[♠ 10]",
            "12,[♠  K]",
            "51,[♦  K]",
            "13,[♣  A]",
            "26,[♥  A]",
            "39,[♦  A]",
    })
    void testNewDeck(int index, String displayChar) {
        Card card;
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            card = deck.drawCardFromTop();
            if (i == index) {
                assertEquals(displayChar, card.toString());
            }
        }
    }

    @Test
    void testDrawUntilEmpty() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.drawCardFromTop();
        }
        assertTrue(deck.isEmpty());
    }
}
