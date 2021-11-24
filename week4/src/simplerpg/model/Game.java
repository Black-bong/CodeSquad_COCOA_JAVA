package simplerpg.model;

import simplerpg.controller.Input;
import simplerpg.domain.*;
import simplerpg.resource.GameKey;
import simplerpg.view.Screen;

public class Game extends Screen {
    //TODO 구현 후 리팩토링 최우선 과제
    /*
    get,set 사용을 줄일려고 이곳에 위치를 저장했는데.. 이럴거였으면 객체로 따로 분리시킨 이유가 있을까..
    이곳에 저장된 값을 사용하지 말고 객체로 값을 보내거나 해서 비교하고 위치를 저장할 수 있는 방법을 생각해보자
     */
    private String[][] gameMap = new String[5][5];
    private int[] monsterLocation = new int[2];
    private int[] trapLocation = new int[2];
    private int[] playerLocation = new int[2];
    private int gameScore = 0;

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
        try {
            String inputKey = input.inputString();
            keyIndex = GameKey.gameKeyList(inputKey);
            moveToPlayer(keyIndex);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력했습니다.");
            System.out.println("다시 입력해주세요.");
            printInputBar();
            inputKey(input);
        }
    }

    private void moveToPlayer(int[] index) {
        try {
            gameMap[playerLocation[0]][playerLocation[1]] = "* ";
            gameMap[playerLocation[0] + index[0]][playerLocation[1] + index[1]] = "P ";
            playerLocation[0] += index[0];
            playerLocation[1] += index[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("맵의 범위를 벗어났습니다.");
            playingGame();
        }
        if (playerLocation[0] == monsterLocation[0] && playerLocation[1] == monsterLocation[1]) {
            gameScore += 100;
            Score score = new Score(gameScore);
            gameWinner(score.getGameScore());
            startGame();
        }
        if (playerLocation[0] == trapLocation[0] && playerLocation[1] == trapLocation[1]) {
            gameOver(gameScore);
        }
        printMap();
        playingGame();
    }

    private void gameOver(int s) {
        printGameOver(s);
    }

    private void gameWinner(int s) {
        printGameWinner(s);
    }

    private void createTrap() {
        Trap trap = new Trap();
        trap.startLocate(monsterLocation[0], monsterLocation[1]);
        trapLocation[0] = trap.getLocationX();
        trapLocation[1] = trap.getLocationY();
        gameMap[trapLocation[0]][trapLocation[1]] = "* ";
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
