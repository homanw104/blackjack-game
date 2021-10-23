package world.homans.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Player class.
 */
public class Player extends CardHolder {

    int balance;
    int bet;

    public Player() {
        this.balance = 100000;
        this.bet = 0;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void deal(ArrayList<Chip> chips) {
        chips.forEach(chip -> bet += chip.getValue());
        balance -= bet;
        setBet(bet);
    }

    public void doubleDeal() {
        balance -= bet;
        bet = 2 * bet;
        setBet(bet);
    }

    public void hit(Deck deck) {
        takeCard(deck);
    }
}
