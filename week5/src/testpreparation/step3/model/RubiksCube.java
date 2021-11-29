package testpreparation.step3.model;

import testpreparation.step3.domain.Cube;
import testpreparation.step3.repository.CubeRepository;
import testpreparation.step3.view.PrintScreen;

import java.util.logging.Logger;


public class RubiksCube extends PrintScreen {

    CubeRepository cubeRepository = CubeRepository.getInstance();
    private static final Logger LOG = Logger.getGlobal();

    public void start() {
        createCube();
    }

    private void createCube() {
        Cube top = new Cube("W", 3, 3);
        cubeRepository.save(top);
        Cube left = new Cube("O", 3, 3);
        cubeRepository.save(left);
        Cube front = new Cube("G", 3, 3);
        cubeRepository.save(front);
        Cube right = new Cube("R", 3, 3);
        cubeRepository.save(right);
        Cube back = new Cube("B", 3, 3);
        cubeRepository.save(back);
        Cube bottom = new Cube("Y", 3, 3);
        cubeRepository.save(bottom);
    }

    public void printCube() {
        cubeRepository.printCube();
    }

    public void cubeExit() {
        endScreen();
    }

    public void movingToLeftBottomLine() {
        System.out.println("D'");
        int cubeKey = 5;
        int cubeLineIndex = 2;
        cubeRepository.leftRotate(cubeKey, cubeLineIndex);
        printCube();
    }

    public void movingToRightBottomLine() {
        System.out.println("D");
        int cubeKey = 5;
        int cubeLineIndex = 2;
        cubeRepository.rightRotate(cubeKey, cubeLineIndex);
        printCube();
    }

    public void movingToDownLeftLine() {
        System.out.println("L");
        int colIndex = 0;
        int cubeKey = 1;
        int backColIndex = 2;
        cubeRepository.downRotate(cubeKey, colIndex, backColIndex);
        printCube();
    }

    public void movingToUpLeftLine() {
        System.out.println("L'");
        int colIndex = 0;
        int cubeKey = 1;
        int backColIndex = 2;
        cubeRepository.upRotate(cubeKey, colIndex, backColIndex);
        printCube();
    }

    public void movingToUpRightLine() {
        System.out.println("R");
        int colIndex = 2;
        int cubeKey = 3;
        int backColIndex = 0;
        cubeRepository.upRotate(cubeKey, colIndex, backColIndex);
        printCube();
    }

    public void movingToDownRightLine() {
        System.out.println("R'");
        int colIndex = 2;
        int cubeKey = 3;
        int backColIndex = 0;
        cubeRepository.downRotate(cubeKey, colIndex, backColIndex);
        printCube();
    }

    public void movingToRightTopLine() {
        System.out.println("U'");
        int cubeKey = 0;
        int cubeLineIndex = 0;
        cubeRepository.rightRotate(cubeKey, cubeLineIndex);
        printCube();
    }

    public void movingToLeftTopLine() {
        System.out.println("U");
        int cubeKey = 0;
        int cubeLineIndex = 0;
        cubeRepository.leftRotate(cubeKey, cubeLineIndex);
        printCube();
    }

    //TODO 구현
    public void movingToLeftFront() {
        System.out.println("F'");
        int cubeKey = 2;
        cubeRepository.reverseRotate(cubeKey);
        printCube();
    }

    //TODO 구현
    public void movingToRightFront() {
        System.out.println("F");
        int cubeKey = 2;
        cubeRepository.rotate(cubeKey);
        printCube();
    }

    //TODO 구현
    public void movingToLeftBack() {
        System.out.println("B");
        int cubeKey = 4;
        cubeRepository.reverseRotate(cubeKey);
        printCube();
    }

    //TODO 구현
    public void movingToRightBack() {
        System.out.println("B'");
        int cubeKey = 4;
        cubeRepository.rotate(cubeKey);
        printCube();
    }
}