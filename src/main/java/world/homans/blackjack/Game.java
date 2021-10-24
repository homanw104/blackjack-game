package world.homans.blackjack;

import java.util.ArrayList;

/**
 * Game class runs a single blackjack game.
 */
public class Game {

    private final Player player;        /* Player object will be passed from the Controller */
    private Dealer dealer;              /* Each game has a new dealer. */
    private Deck deck;                  /* Each game uses a new deck of card. */
    private ArrayList<Chip> bettingBox; /* Stores a set of chips the player bet on this game. */
    private GameStatus gameStatus;      /* Game status. */

    /**
     * When a player join the Game, a new Deck, a new Dealer is prepared.
     * The betting box is cleared for the player.
     * @param player to play the game.
     */
    public Game(Player player) {
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.bettingBox = new ArrayList<>();
        this.player = player;
    }

    /**
     * Game start. Shuffle the deck. Dealer and player draw 2 cards from the deck each.
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
        bettingBox.add(chip);
    }

    /**
     * Clear all the chips in betting box.
     */
    public void clearBet() {
        bettingBox.clear();
    }

    /**
     * Calculate current bet value.
     * @return bet value.
     */
    public int getBet() {
        return bettingBox.stream().mapToInt(Chip::getValue).sum();
    }
//    public GameStatus checkAfterInit() {
//        if (player.calculateTotalPoints() == 21 && dealer.calculateTotalPoints() == 21)
//            return GameStatus.PUSH;
//        else if (player.calculateTotalPoints() == 21)
//            return GameStatus.PLAYER_BLACKJACK;
//        else if (dealer.calculateTotalPoints() == 21)
//            return GameStatus.DEALER_BLACKJACK;
//        return GameStatus.CONTINUE;
//    }

    public GameStatus checkAfterHit() {
        if (player.calculateTotalPoints() > 21)
            return GameStatus.DEALER_WIN;
        return GameStatus.CONTINUE;
    }

    public GameStatus checkAfterStand() {
        if (dealer.calculateTotalPoints() > 21) {
            if (player.calculateTotalPoints() == 21 && player.getHand().size() == 2)
                return GameStatus.PLAYER_BLACKJACK;
            else
                return GameStatus.PLAYER_WIN;
        }
        else if (dealer.calculateTotalPoints() == 21 && dealer.getHand().size() == 2) {
            if (player.calculateTotalPoints() == 21 && player.getHand().size() == 2)
                return GameStatus.PUSH;
            else
                return GameStatus.DEALER_BLACKJACK;
        }
        else if (dealer.calculateTotalPoints() == 21) {
            if (player.calculateTotalPoints() == 21 && player.getHand().size() == 2)
                return GameStatus.PLAYER_BLACKJACK;
            else if (player.calculateTotalPoints() == 21)
                return GameStatus.PUSH;
            else
                return GameStatus.DEALER_WIN;
        }
        else if (dealer.calculateTotalPoints() > player.calculateTotalPoints())
            return GameStatus.DEALER_WIN;
        else if (dealer.calculateTotalPoints() == player.calculateTotalPoints())
            return GameStatus.PUSH;
        else
            return GameStatus.PLAYER_WIN;
    }

    private void checkBet() {
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

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public ArrayList<Chip> getBettingBox() {
        return bettingBox;
    }

    public void setBettingBox(ArrayList<Chip> bettingBox) {
        this.bettingBox = bettingBox;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
