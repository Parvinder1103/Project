package ca.sheridancollege.project;

import java.util.Scanner;

public class Game {
    private final String name;

    public Game(String name) {
        this.name = name;
    }

    public void playGame() {
        GroupOfCards deck = new GroupOfCards();
        deck.shuffle();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        for (int i = 0; i < 7; i++) {
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        System.out.println(player1.getName() + " hand: " + player1.getHand());
        System.out.println(player2.getName() + " hand: " + player2.getHand());

        Player currentPlayer = player1;
        Card currentCard = deck.drawCard(); 
        System.out.println("Initial card on the pile: " + currentCard);

        Scanner scanner = new Scanner(System.in);

        while (!isWinner(player1) && !isWinner(player2)) {
            System.out.println(currentPlayer.getName() + "'s turn");
            System.out.println("Current card on the pile: " + currentCard);
            System.out.println(currentPlayer.getName() + "'s hand: " + currentPlayer.getHand());

            if (canPlay(currentPlayer, currentCard)) {
                Card playedCard = currentPlayer.playCard(currentCard);
                System.out.println(currentPlayer.getName() + " plays: " + playedCard);
                currentCard = playedCard;
            } else {
                System.out.println(currentPlayer.getName() + " draws a card.");
                currentPlayer.drawCard(deck);
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        System.out.println("Game over! " + (isWinner(player1) ? player1.getName() : player2.getName()) + " wins!");
    }

    private boolean canPlay(Player player, Card currentCard) {
        for (Card card : player.getHand()) {
            if (card.matches(currentCard)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinner(Player player) {
        return player.getHand().isEmpty();
    }
}
