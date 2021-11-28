package testpreparation.step3;

import testpreparation.step3.view.PrintScreen;

import java.io.IOException;

public class RubiksCubeMain {
    public static void main(String[] args) throws IOException {
        PrintScreen printScreen = new PrintScreen();
        printScreen.inputScreen();
    }
}