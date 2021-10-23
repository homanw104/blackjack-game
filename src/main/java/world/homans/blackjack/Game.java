package world.homans.blackjack;

import java.util.ArrayList;

/**
 * Game class.
 */
public class Game {

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

    public ArrayList<Chip> getBet() {
        return bet;
    }

    public void setBet(ArrayList<Chip> bet) {
        this.bet = bet;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    Dealer dealer;
    Player player;
    Deck deck;
    ArrayList<Chip> bet;

    private GameStatus gameStatus;

    public Game(Player player) {
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.bet = new ArrayList<>();
        this.player = player;
    }

    public void start() {
        this.deck.shuffle();
        initHand();
    }

    private void initHand() {
        dealer.takeCard(this.deck);
        dealer.takeCard(this.deck);
        player.takeCard(this.deck);
        player.takeCard(this.deck);
    }

    public void increaseBet(Chip chip) {
        bet.add(chip);
    }

    public void clearBet() {
        bet.clear();
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
            player.balance += player.bet * 3;
        }
        else if (getGameStatus() == GameStatus.PUSH) {
            player.balance += player.bet;
        }
        else if (getGameStatus() == GameStatus.PLAYER_WIN) {
            player.balance += player.bet * 2;
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

}
