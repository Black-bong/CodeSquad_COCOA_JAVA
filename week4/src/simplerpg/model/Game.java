package simplerpg.model;

import simplerpg.controller.Input;
import simplerpg.domain.*;
import simplerpg.resource.GameKey;
import simplerpg.view.Screen;

public class Game extends Screen {

    String[][] gameMap = new String[5][5];
    int[] monsterLocation = new int[2];
    int[] trapLocation = new int[2];
    int[] playerLocation = new int[2];

    public void startGame() {
        createMap();
        createPlayer();
        createMonster();
        createTrap();
        printMap();
        playingGame();
    }

    public void playingGame() {
        Input input = new Input();
        printInputBar();
        inputKey(input);
    }

    private void inputKey(Input input) {
        int[] keyIndex;
        String inputKey = input.inputString();
        keyIndex = GameKey.gameKeyList(inputKey);
        moveToPlayer(keyIndex);
    }

    private void moveToPlayer(int[] index) {
        gameMap[playerLocation[0]][playerLocation[1]] = "* ";
        gameMap[playerLocation[0] + index[0]][playerLocation[1] + index[1]] = "P ";
        playerLocation[0] += index[0];
        playerLocation[1] += index[1];
        printMap();
        playingGame();
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
        monster.startLocate(playerLocation[0], playerLocation[1]);
        monsterLocation[0] = monster.getLocationX();
        monsterLocation[1] = monster.getLocationY();
        gameMap[monsterLocation[0]][monsterLocation[1]] = "M ";
    }

    private void createPlayer() {
        Player player = new Player();
        playerLocation[0] = 2;
        playerLocation[1] = 2;
        player.startLocate(playerLocation[0], playerLocation[1]);
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
