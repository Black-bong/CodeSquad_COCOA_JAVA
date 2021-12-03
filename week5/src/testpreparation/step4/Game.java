package testpreparation.step4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public void start() throws IOException {
        BaseBall baseBall = new BaseBall();
        randomNumber(baseBall);
        inputNumber(baseBall);
    }

    private void inputNumber(BaseBall baseBall) throws IOException {
        PrintScreen printScreen = new PrintScreen();
        Input input = new Input();
        List<Integer> inputNumbers;
        int inputCount = 0;
        while (inputCount < 9) {
            inputNumbers = (input.inputInteger(printScreen));
            baseBall.saveInputNumbers(inputNumbers);
            inputCount++;
        }
        printScreen.gameOverScreen();
    }

    private void randomNumber(BaseBall baseBall) {
        Number number = new Number();
        List<Integer> numberList = new ArrayList<>();
        int startNum = 1;
        int endNum = 9;
        int numberCount = 3;
        for (int i = startNum; i < endNum + 1; i++) {
            numberList.add(i);
        }
        numberList = number.getNumber(numberList, numberCount);
        baseBall.saveRandomNumbers(numberList);
    }
}