package testpreparation.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public int inputInteger(PrintScreen printScreen) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        printScreen.inputBar();
        String input = buf.readLine();
        return isInteger(input, printScreen);
    }

    private int isInteger(String input, PrintScreen printScreen) throws IOException {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            printScreen.reInputScreen();
            inputInteger(printScreen);
        }
        return number;
    }
}