package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<Card> cards = new ArrayList<>();

    public GroupOfCards() {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        for (String color : colors) {
            for (String value : values) {
                cards.add(new Card(color, value));
                if (!value.equals("0")) {
                    cards.add(new Card(color, value));
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new Card("Wild", "Color Changer"));
            cards.add(new Card("Wild", "Draw Four"));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(cards.size() - 1);
    }
}
