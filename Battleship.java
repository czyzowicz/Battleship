package sda.java9.prog1.battleship;

public class Battleship extends Ship {
    
    public Battleship(Field a, Field b, Field c, Field d) {
        super("Battleship", 4, new Field[] {a, b, c, d});
    }
}