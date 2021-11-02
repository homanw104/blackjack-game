package world.homans.blackjack;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Player knows his balance and the bet value of current game.
 */
public class Player extends Cardholder {

    private int balance;
    private int bet;

    public Player() {
        this.balance = 100000;
        this.bet = 0;
    }

    /**
     * Player deals the bet and cost equivalent value of chips.
     * Player will remember his bet in this.bet.
     * @param chips The stack of chips that player deals
     */
    public void deal(ArrayList<Chip> chips) {
        chips.forEach(chip -> bet += chip.getValue());
        balance -= bet;
    }

    /**
     * Player doubled the bet by directly cost from his balance.
     * Player will remember his bet in this.bet.
     */
    public void doubleDeal() {
        balance -= bet;
        bet *= 2;
    }

    /**
     * Player hit the deck by taking a card from the deck.
     * @param deck the deck where the card is taken
     */
    public void hit(Deck deck) {
        takeCard(deck);
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void clearBet() {
        bet = 0;
    }

    public int getBet() {
        return bet;
    }

    public int getBalance() {
        return balance;
    }

    public String getBalanceFormatted() {
        DecimalFormat formatter = new DecimalFormat("\t$###,###");
        return formatter.format(balance);
    }
}
