package sda.java9.prog1.battleship;

import java.util.Objects;

public class Field {
    
    private final String row;
    private final String col;
    
    public Field(String row, String col) {
        this.row = row;
        this.col = col;
    }
    public String getRow() { return row; }
    public String getCol() { return col; }
    
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Field)) {
            return false;
        }
        Field other = (Field) o;
        return Objects.equals(this.row, other.row) && Objects.equals(this.col, other.col);
    }
    public String toString() {
        return "Field{row=" + row + ",col=" + col + "}";
    }
}