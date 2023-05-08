module world.homans.blackjack {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    exports world.homans.blackjack;
    opens world.homans.blackjack to javafx.fxml;
    exports world.homans.blackjack.role;
    opens world.homans.blackjack.role to javafx.fxml;
    exports world.homans.blackjack.deck;
    opens world.homans.blackjack.deck to javafx.fxml;
    exports world.homans.blackjack.game;
    opens world.homans.blackjack.game to javafx.fxml;
    exports world.homans.blackjack.controller;
    opens world.homans.blackjack.controller to javafx.fxml;
}
