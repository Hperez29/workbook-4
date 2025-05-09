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

        for (Hand hand : hands) {
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        for (int i = 0; i < hands.size(); i++) {
            String playerName = playerNames.get(i);
            Hand hand = hands.get(i);
            System.out.println(GREEN + playerName + "'s Turn:" + RESET);
            while (hand.getValue() < 21) {
                displayHand(hand);
                System.out.print("Hit or Stay? (H/S): ");
                String choice = scanner.nextLine().toUpperCase();
                if (choice.equals("H")) {
                    hand.deal(deck.deal());
                } else if (choice.equals("S")) {
                    break;
                }
            }

            if (hand.getValue() > 21) {
                System.out.println(RED + playerName + " has busted!" + RESET);
            }
        }

        int highestValue = 0;
        String winner = "";

        for (int i = 0; i < hands.size(); i++) {
            int handValue = hands.get(i).getValue();
            if (handValue > highestValue && handValue <= 21) {
                highestValue = handValue;
                winner = playerNames.get(i);
            }
        }

        if (winner.isEmpty()) {
            System.out.println("No winner, all players busted.");
        } else {
            System.out.println(GREEN + winner + " wins with a total value of " + highestValue + "!" + RESET);
        }
    }

    public static void displayHand(Hand hand) {
        for (Card c : hand.getCards()) {
            displayCard(c);
        }
        System.out.println(GREEN + "Total Value: " + hand.getValue() + RESET);
    }

    public static void displayCard(Card card) {
        System.out.println(YELLOW + "Suit: " + card.getSuit() + RESET);
        System.out.println(BLUE + "Value: " + card.getValue() + RESET);
        System.out.println(RED + "Point Value: " + card.getPointValue() + RESET);
    }
}