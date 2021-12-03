package testpreparation.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    public List<Integer> inputInteger(PrintScreen printScreen) throws IOException {
        Set<Integer> checkBeforeInputNumbers = new HashSet<>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        printScreen.inputBar();
        String input = buf.readLine();
        inputRangeCheck(input, printScreen);
        for (int i = 0; i < input.length(); i++) {
            String inputChar = String.valueOf(input.charAt(i));
            checkBeforeInputNumbers.add(isInteger(inputChar, printScreen));
        }
        return inputDuplicateCheck(input, printScreen, checkBeforeInputNumbers);
    }

    private List<Integer> inputDuplicateCheck(String input, PrintScreen printScreen, Set<Integer> checkBeforeInputNumbers) throws IOException {
        try {
            if (input.length() != checkBeforeInputNumbers.size()) {
                throw new InputNumberDuplicateException();
            }
        } catch (InputNumberDuplicateException e) {
            System.out.println(e.getMessage());
            inputInteger(printScreen);
        }
        return new ArrayList<>(checkBeforeInputNumbers);
    }

    private void inputRangeCheck(String input, PrintScreen printScreen) throws IOException {
        int inputLength = 3;
        try {
            if (input.length() != inputLength) {
                throw new InputNumberRangeException(inputLength);
            }
        } catch (InputNumberRangeException e) {
            System.out.println(e.getMessage());
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