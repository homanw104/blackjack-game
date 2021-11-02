package world.homans.blackjack;

/**
 * Game is considered end when GameStatus is other than CONTINUE.
 */
public enum GameStatus {
    CONTINUE,
    DEALER_WIN,
    PLAYER_WIN,
    PLAYER_BLACKJACK,
    PLAYER_BUSTED,
    PUSH
}
