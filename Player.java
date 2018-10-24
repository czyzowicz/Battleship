package sda.java9.prog1.battleship;

import java.util.regex.*;

public class Player {
    
    private String name;
    private ShipsBoard shipsBoard;
    private ShootingBoard shootingBoard;
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ShootingBoard getShootingBoard() {
        return this.shootingBoard;
    }
    
    public void placeShips() {
        shipsBoard = new ShipsBoard(BattleshipApp.BOARD_SIZE);
        shootingBoard = new ShootingBoard(BattleshipApp.BOARD_SIZE);
        Ship carrier = new Carrier(new Field("1", "A"), new Field("1", "B"),
                                    new Field("1", "C"), new Field("1", "D"), new Field("1", "E"));
		Ship battleship = new Battleship (new Field("3", "A"), new Field("3", "B"),
                                    new Field("3", "C"), new Field("3", "D"));
		Ship cruiser = new Cruiser (new Field("8", "B"), new Field("9", "B"), new Field ("10","B"));							
        Ship destroyer = new Destroyer(new Field("5", "G"), new Field("6", "G"));
		Ship submarine = new Submarine (new Field ("7","J")); 
        shipsBoard.addShip(carrier);
		shipsBoard.addShip(battleship);
		shipsBoard.addShip(cruiser);
        shipsBoard.addShip(destroyer);
		shipsBoard.addShip(submarine);
    }
    
    public boolean hasAnyShips() {
        Ship[] ships = shipsBoard.getShips();
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return true;
            }
        }
        return false;
    }
    
    public Field chooseField() {
        Field choosedField = null;
        while (choosedField == null) {
            System.out.print(">>> Podaj pole do strzału: ");
            String userInput = System.console().readLine();
            Pattern fieldPattern = Pattern.compile("^([A-J])((10)|[1-9])$");
            Matcher matcher = fieldPattern.matcher(userInput);
            if (matcher.matches()) {
                String row = matcher.group(2);
                String col = matcher.group(1);
                choosedField = new Field(row, col);
            }
            else {
                System.out.println("Złe pole!");
            }
        }
        return choosedField;
    }
    
    public String resolveShoot(Field field) {
        Ship ship = shipsBoard.shipAt(field);
        if (ship == null) {
            return "Pudło";
        }
        boolean fire = ship.fireAt(field);
        if (ship.isSunk()) {
            return "Trafiony, zatopiony";
        }
        else {
            return "Trafiony, niezatopiony";
        }
    }
    
    public void markShoot(ShootingField sField) {
        shootingBoard.markField(sField);
    }
}