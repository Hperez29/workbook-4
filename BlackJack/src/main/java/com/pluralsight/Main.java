package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // ANSI color codes
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Hand> hands = new ArrayList<>();
        ArrayList<String> playerNames = new ArrayList<>();

        System.out.print("Enter the number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            playerNames.add(name);
            hands.add(new Hand());
        }

        Deck deck = new Deck();
        deck.shuffle();

        // Deal two cards to each player
        for (Hand hand : hands) {
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        // Display hands and scores
        for (int i = 0; i < hands.size(); i++) {
            String playerName = playerNames.get(i);
            Hand hand = hands.get(i);
            System.out.println(GREEN + playerName + "'s Hand:" + RESET);
            displayHand(hand);
        }

        // Future implementation for determining winner, hit/stay logic, and Ace value adjustment
        System.out.println("Game setup complete. Next steps: Implement hit/stay logic and scoring adjustments.");
    }

    public static void displayHand(Hand hand) {
        for (Card c : hand.getCards()) {
            System.out.println(YELLOW + "Suit: " + c.getSuit() + RESET);
            System.out.println(BLUE + "Value: " + c.getValue() + RESET);
            System.out.println(RED + "Point Value: " + c.getPointValue() + RESET);
        }
        System.out.println(GREEN + "Total Value: " + hand.getValue() + RESET);
    }
}
