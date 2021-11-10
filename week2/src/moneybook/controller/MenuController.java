package moneybook.controller;

import moneybook.model.ReadMenu;
import moneybook.singleton.BufferedReaderSingleton;
import moneybook.model.MainMenu;
import moneybook.model.SubMenu;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuController {

    private int menuNumber;
    BufferedReader bufferedReader = BufferedReaderSingleton.getInstance();

    public void selectMainMenus() throws IOException {
        MainMenu menu = new MainMenu();
        this.menuNumber = Integer.parseInt(bufferedReader.readLine());
        switch (menuNumber) {
            case 1:
                menu.createAccount();
                break;
            case 2:
                menu.login();
                break;
            case 3:
                menu.exit();
        }
    }

    public void selectSubMenus() throws IOException {
        SubMenu subMenu = new SubMenu();
        this.menuNumber = Integer.parseInt(bufferedReader.readLine());
        switch (menuNumber) {
            case 1:
                subMenu.createData();
                break;
            case 2:
                subMenu.readData();
                break;
            case 3:
                subMenu.updateData();
                break;
            case 4:
                subMenu.dataDelete();
                break;
            case 5:
                subMenu.goToMainMenu();
                break;
        }
    }

    public void selectReadMenu() throws IOException {
        ReadMenu readMenu = new ReadMenu();
        this.menuNumber = Integer.parseInt(bufferedReader.readLine());
        switch (menuNumber) {
            case 1:
                readMenu.briefsSearch();
                break;
            case 2:
                readMenu.dateSearch();
                break;
            case 3:
                readMenu.priceSearch();
                break;
            case 4:
                readMenu.earningsSearch();
                break;
            case 5:
                readMenu.expensesSearch();
                break;
            case 6:
                readMenu.consumptionTypeSearch();
                break;
        }
    }
}