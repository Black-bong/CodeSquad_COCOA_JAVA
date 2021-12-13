package testpreparation.step4;

import java.io.IOException;
import java.util.List;

public class Game {

    public void start() throws IOException {
        PrintScreen printScreen = new PrintScreen();
        int count = 0;
        int maxCount = 9;
        List<Integer> inputNumbers;
        List<Integer> randomNumbers = randomNumber();
        while (count < maxCount) {
            inputNumbers = inputNumber(printScreen);
            saveNumber(inputNumbers, randomNumbers);
            count++;
        }
        printScreen.gameOverScreen();
    }

    private List<Integer> inputNumber(PrintScreen printScreen) throws IOException {
        Input input = new Input();
        return input.inputInteger(printScreen);
    }

    private List<Integer> randomNumber() {
        Number number = new Number();
        int startNum = 1;
        int endNum = 10;
        return number.getNumber(startNum, endNum);
    }

    private void saveNumber(List<Integer> inputNumbers, List<Integer> randomNumbers) {
        BaseBall baseBall = new BaseBall();
        baseBall.saveNumbers(inputNumbers, randomNumbers);
    }
}