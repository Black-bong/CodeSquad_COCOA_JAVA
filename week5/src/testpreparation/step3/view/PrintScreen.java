package testpreparation.step3.view;


import testpreparation.step3.model.RubiksCube;


public class PrintScreen {

    public void startScreen(RubiksCube rubiksCube) {
        rubiksCube.printCube();
    }

    public void endScreen() {
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
        System.exit(0);
    }

    public void inputBar() {
        System.out.print("CUBE> ");
    }
}