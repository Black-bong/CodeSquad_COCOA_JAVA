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
        menuBar();
        System.out.println("1. 사용자 등록");
        System.out.println("2. 로그인");
        System.out.println("3. 종료");
        inputBar();
        muc.selectMainMenus();
    }

    public void subMenu() throws IOException {
        menuBar();
        System.out.println("1. 데이터 등록");
        System.out.println("2. 데이터 확인");
        System.out.println("3. 데이터 수정");
        System.out.println("4. 데이터 삭제");
        System.out.println("5. 메인 메뉴");
        inputBar();
        muc.selectSubMenus();
    }

    public void searchMenu() throws IOException {
        menuBar();
        System.out.println("1. 적요");
        System.out.println("2. 날짜");
        System.out.println("3. 금액");
        System.out.println("4. 수입");
        System.out.println("5. 지출");
        System.out.println("6. 소비유형");
        inputBar();
        muc.selectReadMenu();
    }

    public void showResult() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }

    public void inputBar() {
        System.out.print(">> ");
    }

    public void menuBar() {
        System.out.println("========Menu========");
    }
}