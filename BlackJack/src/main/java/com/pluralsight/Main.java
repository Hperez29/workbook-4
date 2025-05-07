package com.pluralsight;

public class Main {
    // ANSI color codes
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";

    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffle();

        Hand h1 = new Hand();

        Card c1 = d.deal();
        c1.flip();

        displayCard(c1);

        Card c2 = d.deal();
        c2.flip();

        displayCard(c2);

        h1.deal(c1);
        h1.deal(c2);

        System.out.println();
        System.out.println(GREEN + "Hand Value: " + h1.getValue() + RESET);
    }

    public static void displayCard(Card c) {
        System.out.println(YELLOW + "Suit: " + c.getSuit() + RESET);
        System.out.println(BLUE + "Value: " + c.getValue() + RESET);
        System.out.println(RED + "Point Value: " + c.getPointValue() + RESET);
    }
}
