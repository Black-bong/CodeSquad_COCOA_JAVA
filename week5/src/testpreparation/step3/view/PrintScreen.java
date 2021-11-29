package testpreparation.step3.view;


import testpreparation.step3.model.RubiksCube;
import testpreparation.step3.controller.Commend;
import testpreparation.step3.resource.Input;

import java.io.IOException;

public class PrintScreen {

    public void inputScreen() throws IOException {
        RubiksCube rubiksCube = new RubiksCube();
        rubiksCube.start();
        Commend commend = new Commend();
        Input input = new Input();
        while (true) {
            rubiksCube.printCube();
            System.out.print("CUBE> ");
            commend.splitInputString(input.inputString());
        }
    }

    public void endScreen() {
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
        System.exit(0);
    }
}