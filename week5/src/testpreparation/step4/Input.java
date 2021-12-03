package testpreparation.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public List<Integer> inputInteger(PrintScreen printScreen) throws IOException {
        List<Integer> inputNumbers = new ArrayList<>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        printScreen.inputBar();
        String input = buf.readLine();
        inputRangeCheck(input, printScreen);
        for (int i = 0; i < input.length(); i++) {
            String inputChar = String.valueOf(input.charAt(i));
            inputNumbers.add(isInteger(inputChar, printScreen));
        }
        return inputNumbers;
    }

    private void inputRangeCheck(String input, PrintScreen printScreen) throws IOException {
        try {
            if (input.length() > 3) {
                throw new InputNumberRangeException();
            }
        } catch (InputNumberRangeException e) {
            printScreen.reInputScreen();
            inputInteger(printScreen);
        }
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