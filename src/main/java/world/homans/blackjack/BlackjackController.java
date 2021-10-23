package world.homans.blackjack;

import javafx.fxml.FXML;

public class BlackjackController {

    Player player = new Player();
    Dealer dealer;
    Deck deck;
    Game game;

    /**
     * Player adds a $100 value chip to the bet.
     */
    @FXML
    protected void onBet100ChipClicked() {
//        game.increaseBet(new Chip(100));
        System.out.println("Bet 100");
    }

    /**
     * Player adds a $500 value chip to the bet.
     */
    @FXML
    protected void onBet500ChipClicked() {
//        game.increaseBet(new Chip(500));
        System.out.println("Bet 500");
    }

    /**
     * Player adds a $1000 value chip to the bet.
     */
    @FXML
    protected void onBet1000ChipClicked() {
//        game.increaseBet(new Chip(1000));
        System.out.println("Bet 1000");
    }

    /**
     * Player adds a $5000 value chip to the bet.
     */
    @FXML
    protected void onBet5000ChipClicked() {
//        game.increaseBet(new Chip(5000));
        System.out.println("Bet 5000");
    }

    /**
     * Cancel the bet and return all chips.
     */
    @FXML
    protected void onCancelButtonClick() {

    }

    /**
     * Deal the bet (chips) and start the game.
     */
    @FXML
    protected void onDealButtonClick() {

    }

    /**
     * Player takes no more cards.
     */
    @FXML
    protected void onStandButtonClick() {

    }

    /**
     * Player takes another card.
     */
    @FXML
    protected void onHitButtonClick() {

    }

    /**
     * Player double the bet and take exactly one more card.
     */
    @FXML
    protected void onDoubleButtonClick() {

    }
}
