package sda.java9.prog1.battleship;

public abstract class Ship {
    
    private int size;
    private Field[] deck;
    private Field[] hitDeck;
    private String name;
    
    public Ship(String name, int size, Field... deck) {
        this.name = name;
        this.size = size;
        this.deck = deck;
        this.hitDeck = new Field[deck.length];
    }
    
    public String getName() { return name; }
    
    public boolean isOnField(Field field) {
        for (Field f : deck) {
            if (f.equals(field)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean fireAt(Field field) {
        if (isOnField(field)) {
            for (Field f : hitDeck) {
                if (f != null && f.equals(field)) {
                    return false;
                }
            }
            for (int i = 0; i < hitDeck.length; i++) {
                if (hitDeck[i] == null) {
                    hitDeck[i] = field;
                    break;
                }
            }
            return true;
        }
        else {
            throw new IllegalArgumentException("Po co tam strzelasz, jak mnie tam nie ma?!");
        }
    }
    
    public boolean isSunk() {
        for (int i = 0; i < hitDeck.length; i++) {
            if (hitDeck[i] == null) {
                return false;
            }
        }
        return true;
    }
    
    
}