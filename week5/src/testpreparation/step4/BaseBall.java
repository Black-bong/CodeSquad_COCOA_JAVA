package testpreparation.step4;

import java.util.List;

public class BaseBall {

    public void saveNumbers(List<Integer> inputNumber, List<Integer> randomNumber) {
        PrintScreen printScreen = new PrintScreen();
        isSameAll(printScreen, inputNumber, randomNumber);
        checkBallAndStrike(printScreen, inputNumber, randomNumber);
    }

    private void checkBallAndStrike(PrintScreen printScreen, List<Integer> inputNumber, List<Integer> randomNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < randomNumber.size(); i++) {
            if (numberCheck(inputNumber.get(i), randomNumber.get(i), randomNumber) == 1) {
                strike++;
            }
            if (numberCheck(inputNumber.get(i), randomNumber.get(i), randomNumber) == 2)
                ball++;
        }
        printScreen.strike(strike);
        printScreen.ball(ball);
        isSameNoting(printScreen, strike, ball);
        System.out.println();
    }

    private void isSameNoting(PrintScreen printScreen, int strike, int ball) {
        if (strike == 0 && ball == 0) {
            printScreen.notingScreen();
        }
    }

    private int numberCheck(int inputNumber, int randomNumber, List<Integer> randomNumbers) {
        if (randomNumber == inputNumber) {
            return 1;
        }
        if (randomNumbers.contains(inputNumber)) {
            return 2;
        }
        return 3;
    }

    private void isSameAll(PrintScreen printScreen, List<Integer> inputNumber, List<Integer> randomNumber) {
        if (inputNumber.equals(randomNumber)) {
            printScreen.winGameScreen(randomNumber.size());
        }
    }
}