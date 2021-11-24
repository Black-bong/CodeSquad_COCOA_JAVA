package simplerpg.model;

import simplerpg.domain.*;

public class Game {

    String[][] gameMap = new String[5][5];
    int[] monsterLocation = new int[2];
    int[] trapLocation = new int[2];

    public void startGame() {
        createMap();
        createPlayer();
        createMonster();
        createTrap();
        printMap();
    }

    private void createTrap() {
        Trap trap = new Trap();
        trap.startLocate(monsterLocation[0], monsterLocation[1]);
        trapLocation[0] = trap.getLocationX();
        trapLocation[1] = trap.getLocationY();
        gameMap[trapLocation[0]][trapLocation[1]] = "T ";
    }

    private void createMonster() {
        Monster monster = new Monster();
        monster.startLocate(2, 2);
        monsterLocation[0] = monster.getLocationX();
        monsterLocation[1] = monster.getLocationY();
        gameMap[monsterLocation[0]][monsterLocation[1]] = "M ";
    }

    private void createPlayer() {
        Player player = new Player();
        player.startLocate(2, 2);
        gameMap[player.getLocationX()][player.getLocationY()] = "P ";
    }

    private void createMap() {
        Map map = new Map();
        gameMap = map.createMap();
    }

    public void printMap() {
        for (String[] strings : gameMap) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
