package sda.java9.prog1.battleship;

public class ShipsBoard {
    
    private int size;
    private Ship[] ships;
    
    public ShipsBoard(int size) {
        this.size = size;
        this.ships = new Ship[BattleshipApp.SHIPS_COUNT];
    }
    
    public Ship[] getShips() {
        return this.ships;
    }
    
    public void addShip(Ship s) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = s;
                break;
            }
        }
    }
    
    public Ship shipAt(Field field) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] != null && ships[i].isOnField(field)) {
                return ships[i];
            }
        }
        return null;
    }
}