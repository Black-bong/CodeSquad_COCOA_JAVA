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
        List<Integer> inputNumbers = new ArrayList<>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        printScreen.inputBar();
        String input = buf.readLine();
        inputRangeCheck(input, printScreen);
        for (int i = 0; i < input.length(); i++) {
            String inputChar = String.valueOf(input.charAt(i));
            inputNumbers.add(isInteger(inputChar, printScreen));
        }
        inputDuplicateCheck(inputNumbers, printScreen);
        return inputNumbers;
    }

    private void inputDuplicateCheck(List<Integer> inputNumbers, PrintScreen printScreen) throws IOException {
        Set<Integer> checkBeforeInputNumbers = new HashSet<>(inputNumbers);
        try {
            if (checkBeforeInputNumbers.size() != inputNumbers.size()) {
                throw new InputNumberDuplicateException();
            }
        } catch (InputNumberDuplicateException e) {
            System.out.println(e.getMessage());
            inputInteger(printScreen);
        }
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