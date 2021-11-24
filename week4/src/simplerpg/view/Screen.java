package simplerpg.view;


import simplerpg.controller.Menu;

public class Screen {

    public void printMainScreen() {
        Menu menu = new Menu();
        System.out.println("==게임시작==");
        menu.startMenu();
    }
}