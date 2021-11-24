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

    public void printGameWinner(int score) {
        System.out.println("몬스터를 처치했습니다.");
        System.out.println("점수획득!!!!!");
        System.out.println("현재 점수: " + score);
        System.out.println("==게임시작==");
    }

    public void printGameOver(int totalScore) {
        System.out.println("함정에 걸렸습니다.");
        System.out.println("최종 점수: " + totalScore);
        System.out.println("게임오버");
        System.exit(0);
    }
}