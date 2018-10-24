package sda.java9.prog1.battleship;

import java.util.Arrays;

public class ShootingBoard {
    
    private ShootingField[] fields;
    
    public ShootingBoard(int size) {
        fields = new ShootingField[size * size];
    }
    
    public void markField(ShootingField field) {
        for (ShootingField f : fields) {
            if (f != null && f.equals(field)) {
                return;
            }
        }
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == null) {
                fields[i] = field;
                break;
            }
        }
    }
    
    public String toString() {
        return "ShootingBoard{fields=" + Arrays.toString(fields) + "}";
    }
}