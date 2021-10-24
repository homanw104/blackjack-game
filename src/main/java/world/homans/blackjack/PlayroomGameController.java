package world.homans.blackjack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PlayroomGameController {

    Player player;
    Game game;

    @FXML Text txtBalance;
    @FXML Text txtPlayerPoint;
    @FXML Text txtDealerPoint;
    @FXML StackPane playerPointBanner;
    @FXML StackPane dealerPointBanner;

    @FXML Button btnStand;
    @FXML Button btnDouble;
    @FXML Button btnSurrender;
    @FXML Button btnHit;

    @FXML ImageView playerCard1;
    @FXML ImageView playerCard2;
    @FXML ImageView playerCard3;
    @FXML ImageView playerCard4;
    @FXML ImageView playerCard5;
    @FXML ImageView playerCard6;
    @FXML ImageView playerCard7;
    @FXML ImageView playerCard8;

    @FXML ImageView dealerCard1;
    @FXML ImageView dealerCard2;
    @FXML ImageView dealerCard3;
    @FXML ImageView dealerCard4;
    @FXML ImageView dealerCard5;
    @FXML ImageView dealerCard6;
    @FXML ImageView dealerCard7;
    @FXML ImageView dealerCard8;

    /**
     * Load player and game into the view.
     * @param player player to been shown on the UI as well as who plays the game
     * @param game the game which player has started
     */
    public void loadContents(Player player, Game game) {
        this.player = player;
        this.game = game;
        updateScene();
    }

    /**
     * Player takes no more cards.
     */
    @FXML
    protected void onStandButtonClick() {
        System.out.println("Player Stand");
        game.getDealer().hitTillSeventeen(game.getDeck());
        game.checkAfterStand();
        updateScene();
    }

    /**
     * Player takes another card.
     */
    @FXML
    protected void onHitButtonClick() {
        System.out.println("Player Hit");
        player.hit(game.getDeck());
        game.checkAfterHit();
        updateScene();
    }

    /**
     * Player double the bet and take exactly one more card.
     */
    @FXML
    protected void onDoubleButtonClick() {
        System.out.println("Player Double");
        player.doubleDeal();
        updateScene();
    }

    /**
     * Player surrender. Forfeit half the bet and end the hand immediately.
     */
    @FXML
    protected void onSurrenderButtonClick() {
        System.out.println("Player Surrendered");
        updateScene();
    }

    /**
     * Update cards' image and player's balance in the scene.
     */
    private void updateScene() {
        /* These lists help keep track of all the cards displayed on the UI. */
        ArrayList<ImageView> imgPlayerCards = new ArrayList<>(
                List.of(playerCard1, playerCard2, playerCard3, playerCard4,
                        playerCard5, playerCard6, playerCard7, playerCard8)
        );
        ArrayList<ImageView> imgDealerCards = new ArrayList<>(
                List.of(dealerCard1, dealerCard2, dealerCard3, dealerCard4,
                        dealerCard5, dealerCard6, dealerCard7, dealerCard8)
        );

        /* Update player's balance. */
        txtBalance.setText(player.getBalanceFormatted());

        /* Update player's hand. */
        Iterator<Card> playerHand = player.getHand().iterator();
        for (ImageView img: imgPlayerCards) {
            if (playerHand.hasNext()) {
                String url = playerHand.next().getImageUrl();
                Image image = new Image(Objects.requireNonNull(getClass().getResource(url)).toString());
                img.setVisible(true);
                img.setImage(image);
            } else {
                img.setVisible(false);
            }
        }

        /* Update dealer's hand. */
        Iterator<Card> dealerHandIter = game.getDealer().getHand().iterator();
        for (ImageView img: imgDealerCards) {
            if (dealerHandIter.hasNext()) {
                String url = dealerHandIter.next().getImageUrl();
                Image image = new Image(Objects.requireNonNull(getClass().getResource(url)).toString());

                /* Set the second card to be hidden if dealer have 2 cards. */
                if (game.getDealer().getHand().size() == 2 && !dealerHandIter.hasNext()) {
                    url = "/img/card_back_1.png";
                    image = new Image(Objects.requireNonNull(getClass().getResource(url)).toString());
                }

                img.setVisible(true);
                img.setImage(image);
            } else {
                img.setVisible(false);
            }
        }

        /* Update player's point. */
        txtPlayerPoint.setText(String.valueOf(player.getTotalPoints()));

        /* Update dealer's point. Hide dealer's point banner if dealer have 2 cards. */
        if (game.getDealer().getHand().size() == 2) {
            dealerPointBanner.setVisible(false);
        } else {
            dealerPointBanner.setVisible(true);
            txtDealerPoint.setText(String.valueOf(game.getDealer().getTotalPoints()));
        }
    }

    private void switchToBetScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(BlackjackApplication.class.getResource("playroom-bet-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 960, 540);
            BlackjackApplication.getPrimaryStage().setScene(scene);
            PlayroomBetController betController = fxmlLoader.getController();
            betController.loadContents(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
