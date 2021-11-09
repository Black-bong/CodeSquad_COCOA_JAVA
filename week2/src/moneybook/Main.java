package moneybook;

import moneybook.view.MoneyBook;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MoneyBook moneyBook = new MoneyBook();
        moneyBook.start();
    }
}