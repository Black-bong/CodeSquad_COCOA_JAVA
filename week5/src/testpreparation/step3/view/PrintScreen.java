package testpreparation.step3.view;


import testpreparation.step3.repository.CubeRepository;


public class PrintScreen extends CubeRepository {

    public void startScreen() {
        printCube();
    }

    public void endScreen(int count) {
        System.out.println("경과시간: ");
        System.out.println("조각갯수: " + (count + 1));
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
    }

    public void inputBar() {
        System.out.print("CUBE> ");
    }
}