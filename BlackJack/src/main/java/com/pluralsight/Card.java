package com.pluralsight;

public class Card {

    private final String suit;
    private String value;
    private boolean isfaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isfaceUp = true;  // Cards are face up by default
    }

    public String getValue() {
        return this.value;
    }

    public String getSuit() {
        if (isfaceUp) {
            return this.suit;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        switch (this.value) {
            case "A":
                return 11;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
            case "J":
            case "Q":
            case "K":
                return 10;
        }
        return 0;
    }

    public boolean isFaceUp() {
        return this.isfaceUp;
    }

    public void flip() {
        this.isfaceUp = !this.isfaceUp;
    }

    public void reveal() {
        this.isfaceUp = true;
    }

    public void hide() {
        this.isfaceUp = false;
    }
}
