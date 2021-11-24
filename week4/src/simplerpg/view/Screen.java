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

    public void printGameWinner() {
        System.out.println("몬스터를 처치했습니다.");
        System.out.println("게임승리");
        System.exit(0);
    }

    public void printGameOver() {
        System.out.println("함정에 걸렸습니다.");
        System.out.println("게임오버");
        System.exit(0);
    }
}