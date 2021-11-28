package testpreparation.step3.view;


import testpreparation.step3.Model.RubiksCube;
import testpreparation.step3.controller.Commend;
import testpreparation.step3.resource.Input;

import java.io.IOException;

public class PrintScreen {

    public void inputScreen() throws IOException {
        cubeScreen();
        Commend commend = new Commend();
        Input input = new Input();
        System.out.print("CUBE> ");
        commend.splitCommend(input.inputString());
    }

    public void cubeScreen() {
        RubiksCube rubiksCube = new RubiksCube();
        rubiksCube.start();
        rubiksCube.printCube();
    }
}