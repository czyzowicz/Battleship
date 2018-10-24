package sda.java9.prog1.battleship;

public class Destroyer extends Ship {
    
    public Destroyer(Field a, Field b) {
        super("Destroyer", 2, new Field[] {a, b});
    }
}