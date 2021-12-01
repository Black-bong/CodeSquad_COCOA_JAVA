package testpreparation.step3.view;


import testpreparation.step3.model.RubiksCube;


public class PrintScreen {

    public void inputScreen() {
        RubiksCube rubiksCube = new RubiksCube();
        rubiksCube.start();
        rubiksCube.printCube();
        System.out.print("CUBE> ");
    }

    public void endScreen() {
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
        System.exit(0);
    }
}