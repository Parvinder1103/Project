package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final String name;
    private final ArrayList<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(GroupOfCards deck) {
        hand.add(deck.drawCard());
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public Card playCard(Card currentCard) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the index of the card you want to play (0 to " + (hand.size() - 1) + "): ");
        int index = scanner.nextInt();

        while (index < 0 || index >= hand.size() || !hand.get(index).matches(currentCard)) {
            System.out.println("Invalid choice. Try again.");
            index = scanner.nextInt();
        }

        return hand.remove(index);
    }
}
