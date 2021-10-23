package world.homans.blackjack;

/**
 * Playroom starts the game. A Playroom includes a player,
 * a dealer, and a Deck.
 */
public class Playroom {

    Player player;

    public Playroom() {
        this.player = new Player();
    }

    /**
     *  Reset the Deck, the Dealer role and the Player Role.
     */
    public void newGame() {
        Game game = new Game(this.player);
        game.start();
    }
}
