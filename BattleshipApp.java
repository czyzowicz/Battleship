package sda.java9.prog1.battleship;

import java.util.Scanner;

public class BattleshipApp {
    
    public static final int BOARD_SIZE = 10;
    public static final int SHIPS_COUNT = 7;
    
    public static void main(String[] args) {
        String firstPlayerName;
        String secondPlayerName;
		
		Player firstPlayer;
        Player secondPlayer;	
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Podaj nazwę pierwszego gracza");
		firstPlayerName = input.next();
		Player p1 = new Player(firstPlayerName);
        	
		System.out.println("Podaj nazwę drugiego gracza");
		secondPlayerName = input.next();
		Player p2 = new Player(secondPlayerName); 
        
        System.out.println("Gracze przygotowują plansze");
        p1.placeShips();
        p2.placeShips();
        
        boolean firstAsFirst = ((int) (100 * Math.random())) % 2 == 0 ? true : false;
        if (firstAsFirst) {
            firstPlayer = p1;
            secondPlayer = p2;
        }
        else {
            firstPlayer = p2;
            secondPlayer = p1;
        }
        
		
        while (firstPlayer.hasAnyShips() && secondPlayer.hasAnyShips()) {
            System.out.println(firstPlayer.getName() + "Twoja kolej ");
			Field choosedField = firstPlayer.chooseField();
            String result = secondPlayer.resolveShoot(choosedField);
            ShootingField sField;
            switch (result) {
                case "Pudło":
                    sField = new ShootingField(choosedField.getRow(), choosedField.getCol(), true, false);
                    firstPlayer.markShoot(sField);
                    break;
                case "Trafiony, niezatopiony":
                    sField = new ShootingField(choosedField.getRow(), choosedField.getCol(), false, false);
                    firstPlayer.markShoot(sField);
                    break;
                case "Trafiony, zatopiony":
                    sField = new ShootingField(choosedField.getRow(), choosedField.getCol(), false, true);
                    firstPlayer.markShoot(sField);
                    break;
                default:
                    System.err.println("Nie wiem o co kaman z tym: " + result);
            }
            System.out.println(result);
            System.out.println(firstPlayer.getShootingBoard());
			
			System.out.println(secondPlayer.getName() + "Twoja kolej ");
            choosedField = secondPlayer.chooseField();
            result = firstPlayer.resolveShoot(choosedField);
            switch (result) {
                case "Pudło":
                    sField = new ShootingField(choosedField.getRow(), choosedField.getCol(), true, false);
                    secondPlayer.markShoot(sField);
                    break;
                case "Trafiony, niezatopiony":
                    sField = new ShootingField(choosedField.getRow(), choosedField.getCol(), false, false);
                    secondPlayer.markShoot(sField);
                    break;
                case "Trafiony, zatopiony":
                    sField = new ShootingField(choosedField.getRow(), choosedField.getCol(), false, true);
                    secondPlayer.markShoot(sField);
                    break;
                default:
                    System.err.println("Nie wiem o co kaman z tym: " + result);
            }   
            System.out.println(result);
            System.out.println(secondPlayer.getShootingBoard());
            
        }
        
        if (firstPlayer.hasAnyShips() && !secondPlayer.hasAnyShips()) {
            System.out.println("Wygrał gracz " + firstPlayer.getName());
        }
        else if (!firstPlayer.hasAnyShips() && secondPlayer.hasAnyShips()) {
            System.out.println("Wygrał gracz " + secondPlayer.getName());
        }
        else {
            System.out.println("REMIS!");
        }
    }
}