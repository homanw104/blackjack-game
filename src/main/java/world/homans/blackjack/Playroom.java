package world.homans.blackjack;

/**
 * Playroom starts the game. A Playroom includes a player,
 * a dealer, and a Deck.
 */
public class Playroom {

    Dealer dealer;
    Player player;
    Deck deck;

    public Playroom() {
        // TODO
        this.dealer = new Dealer();
        this.player = new Player();
        this.deck = new Deck();
    }

    /**
     *  Reset the Deck, the Dealer role and the Player Role.
     */
    public void startGame() {
        this.deck.shuffle();
        // TODO More code ...
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack Game!");
    }
}
