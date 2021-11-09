package moneybook.view;

import moneybook.controller.MenuController;

import java.io.IOException;

public class MoneyBook {

    MenuController muc = new MenuController();

    public void start() throws IOException {
        System.out.println("========가계부========");
        mainMenu();
    }

    public void mainMenu() throws IOException {
        System.out.println("========MainMenu========");
        System.out.println("1. 사용자 등록");
        System.out.println("2. 로그인");
        System.out.println("3. 종료");
        System.out.print(">> ");
        muc.selectMainMenus();
    }

    public void subMenu() throws IOException {
        System.out.println("========Menu========");
        System.out.println("1. 데이터 등록");
        System.out.println("2. 데이터 확인");
        System.out.println("3. 데이터 수정");
        System.out.println("4. 데이터 삭제");
        System.out.println("5. 메인 메뉴");
        System.out.print(">> ");
        muc.selectSubMenus();
    }

    public void showResult() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}