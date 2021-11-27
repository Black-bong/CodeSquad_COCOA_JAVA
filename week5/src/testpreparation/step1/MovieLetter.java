package testpreparation.step1;

import java.io.IOException;

public class MovieLetter {

    public void start() throws IOException {
        Input input = new Input();
        System.out.print("> ");
        String inputLetter = input.inputString();
        splitLetter(inputLetter);
    }

    private void splitLetter(String inputText) {
        String[] letters = inputText.split(" +");
        String letter = letters[0];
        int moveCount = Integer.parseInt(letters[1]);
        String moveDirection = letters[2];
        movingToLetter(letter, moveCount, moveDirection);
    }

    private void movingToLetter(String letter, int moveCount, String moveDirection) {
        char[] queue = new char[letter.length()];
        if (moveDirection.equals("r") && moveCount > 0) {
            movingToRight(letter, moveCount, queue);
        }
        if (moveDirection.equals("r") && moveCount < 0) {
            movingToLeft(letter, moveCount * - 1, queue);
        }

        if (moveDirection.equals("l") && moveCount > 0) {
            movingToLeft(letter, moveCount, queue);
        }
        if (moveDirection.equals("l") && moveCount < 0) {
            movingToRight(letter, moveCount * - 1, queue);
        }
    }

    private void movingToLeft(String letter, int moveCount, char[] queue) {
        for (int i = 0; i < letter.length(); i++) {
            queue[i] = letter.charAt(moveCount++ % queue.length);
        }
        printLetter(queue);
    }

    private void movingToRight(String letter, int moveCount, char[] queue) {
        for (int i = 0; i < letter.length(); i++) {
            queue[i] = letter.charAt((moveCount * 4 + i) % queue.length);
        }
        printLetter(queue);
    }

    private void printLetter(char[] queue) {
        for (var c : queue) {
            System.out.print(c);
        }
    }
}
