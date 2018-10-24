package sda.java9.prog1.battleship;

public class Carrier extends Ship {
    
    public Carrier(Field a, Field b, Field c, Field d, Field e) {
        super("Carrier", 5, new Field[] {a, b, c, d, e});
    }
}