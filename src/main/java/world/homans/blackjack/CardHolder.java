package world.homans.blackjack;

import java.util.ArrayList;
import java.util.List;

public class CardHolder {
    private List<Card> hand;

    public CardHolder() {
        hand = new ArrayList<>();
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void takeCard(Deck deck) {
        Card card = deck.drawCardFromTop();
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int calculateTotalPoints() {
        int points = 0;
        int aceCount = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() == CardRank.ACE)
                aceCount++;
            else
                points += hand.get(i).getRank().getPoints();
        }
        while (aceCount-- > 0) {
            if (points + 11 <= 21)
                points += 11;
            else
                points++;
        }
        return points;
    }
}
