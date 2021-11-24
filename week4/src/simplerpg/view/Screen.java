package simplerpg.view;


import simplerpg.controller.Menu;

public class Screen {

    public void printMainScreen() {
        Menu menu = new Menu();
        System.out.println("==게임시작==");
        menu.startMenu();
    }

    public void printInputBar() {
        System.out.println("방향키를 입력하세요.(WASD)");
        System.out.print("> ");
    }
}