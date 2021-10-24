package world.homans.blackjack;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Player class.
 */
public class Player extends Cardholder {

    private int balance;
    private int bet;

    public Player() {
        this.balance = 100000;
        this.bet = 0;
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

    public int getBet() {
        return bet;
    }

    public int getBalance() {
        return balance;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBalanceFormatted() {
        DecimalFormat formatter = new DecimalFormat("\t$###,###");
        return formatter.format(balance);
    }
}
