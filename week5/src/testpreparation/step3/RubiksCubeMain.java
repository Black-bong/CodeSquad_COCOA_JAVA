package testpreparation.step3;

import testpreparation.step3.controller.Commend;
import testpreparation.step3.model.RubiksCube;
import testpreparation.step3.view.PrintScreen;

import java.io.IOException;


public class RubiksCubeMain {
    public static void main(String[] args) throws IOException {
        RubiksCube rubiksCube = new RubiksCube();
        PrintScreen printScreen = new PrintScreen();
        Commend commend = new Commend();
        rubiksCube.start();
        printScreen.startScreen(rubiksCube);
        commend.inputCommend(printScreen);
    }
}