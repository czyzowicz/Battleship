package sda.java9.prog1.battleship;

public class Cruiser extends Ship {
    
    public Cruiser(Field a, Field b, Field c) {
        super("Cruiser", 3, new Field[] {a, b, c});
    }
}