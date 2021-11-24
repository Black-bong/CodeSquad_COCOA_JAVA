package simplerpg.view;

import simplerpg.domain.Map;

public class Screen {
    public void printMainScreen() {
        for (int i = 0; i < 50; i++) {
            Map map = new Map();
            System.out.println("==게임시작==");
            map.printMap();
        }
    }
}