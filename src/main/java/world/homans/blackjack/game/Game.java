package world.homans.blackjack.game;

import world.homans.blackjack.deck.Deck;
import world.homans.blackjack.role.Dealer;
import world.homans.blackjack.role.Player;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Game class runs a single blackjack game session.
 * A game session is to be destroyed when the game ends.
 */
public class Game {

    private final Player player;                /* Player object will be passed from the Controller */
    private final Dealer dealer;                /* Each game has a new dealer. */
    private final Deck deck;                    /* Each game uses a new deck of card. */
    private final ArrayList<Chip> chips;        /* Stores a set of chips the player bet on this game. */
    private GameStatus gameStatus;              /* Game status. */

    /**
     * When a player join the Game, a new Deck, a new Dealer is prepared.
     * The betting box is cleared for the player.
     * @param player to play the game.
     */
    public Game(Player player) {
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.chips = new ArrayList<>();
        this.player = player;
        this.gameStatus = GameStatus.CONTINUE;
    }

    /**
     * Game start. Shuffle the deck. Dealer and player draw 2 cards each from the deck.
     */
    public void start() {
        deck.shuffle();
        dealer.takeCard(deck);
        dealer.takeCard(deck);
        player.takeCard(deck);
        player.takeCard(deck);
    }

    /**
     * Increase bet by placing one more chip in betting box.
     * @param chip A chip.
     */
    public void increaseBet(Chip chip) {
        chips.add(chip);
    }

    /**
     * Clear all the chips in betting box.
     */
    public void clearBet() {
        chips.clear();
    }

    /**
     * Calculate current bet value.
     * @return bet value.
     */
    public int getCurrentBetValue() {
        return chips.stream().mapToInt(Chip::getValue).sum();
    }

    /**
     * Calculate current bet value and format.
     * @return bet value string formatted as "Bet: $1,000"
     */
    public String getCurrentBetValueFormatted() {
        DecimalFormat formatter = new DecimalFormat("\t$###,###");
        return "Bet: " + formatter.format(getCurrentBetValue());
    }

    /**
     * Update gameStatus based on whether player has busted.
     */
    public void checkAfterHit() {
        if (player.getTotalPoints() > 21)
            gameStatus = GameStatus.PLAYER_BUSTED;
        else
            gameStatus = GameStatus.CONTINUE;
    }

    /**
     * Update gameStatus based on player and dealer's hands.
     */
    public void checkAfterStand() {
        if (dealer.getTotalPoints() > 21) {
            if (player.getTotalPoints() == 21 && player.getHand().size() == 2)
                gameStatus = GameStatus.PLAYER_BLACKJACK;
            else
                gameStatus = GameStatus.PLAYER_WIN;
        } else if (dealer.getTotalPoints() == 21) {
            if (player.getTotalPoints() == 21 && player.getHand().size() == 2)
                gameStatus = GameStatus.PLAYER_BLACKJACK;
            else if (player.getTotalPoints() == 21)
                gameStatus = GameStatus.PUSH;
            else
                gameStatus = GameStatus.DEALER_WIN;
        } else if (dealer.getTotalPoints() > player.getTotalPoints()) {
            gameStatus = GameStatus.DEALER_WIN;
        } else if (dealer.getTotalPoints() == player.getTotalPoints()) {
            gameStatus = GameStatus.PUSH;
        } else {
            if (player.getTotalPoints() == 21 && player.getHand().size() == 2)
                gameStatus = GameStatus.PLAYER_BLACKJACK;
            else
                gameStatus = GameStatus.PLAYER_WIN;
        }
        rewardPlayer();
    }

    /**
     * Reward player according to gameStatus and player's previous bet.
     */
    private void rewardPlayer() {
        if (getGameStatus() == GameStatus.PLAYER_BLACKJACK) {
            player.setBalance(player.getBalance() + player.getBet() * 3);
        }
        else if (getGameStatus() == GameStatus.PUSH) {
            player.setBalance(player.getBalance() + player.getBet());
        }
        else if (getGameStatus() == GameStatus.PLAYER_WIN) {
            player.setBalance(player.getBalance() + player.getBet() * 2);
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }
}
