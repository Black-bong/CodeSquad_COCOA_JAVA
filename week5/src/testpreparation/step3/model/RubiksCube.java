package testpreparation.step3.model;

import testpreparation.step3.domain.Cube;
import testpreparation.step3.repository.CubeRepository;
import testpreparation.step3.view.PrintScreen;



public class RubiksCube extends PrintScreen {

    CubeRepository cubeRepository = CubeRepository.getInstance();

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

    }

    public void movingToRightBottomLine() {
        System.out.println("D");

    }

    public void movingToDownLeftLine() {
        System.out.println("L");

    }

    public void movingToUpLeftLine() {
        System.out.println("L'");

    }

    public void movingToUpRightLine() {
        System.out.println("R");

    }

    public void movingToDownRightLine() {
        System.out.println("R'");

    }

    public void movingToRightTopLine() {
        System.out.println("U'");

    }

    public void movingToLeftTopLine() {
        System.out.println("U");

    }


    public void movingToLeftFront() {
        System.out.println("F'");

    }


    public void movingToRightFront() {
        System.out.println("F");

    }


    public void movingToLeftBack() {
        System.out.println("B");

    }


    public void movingToRightBack() {
        System.out.println("B'");

    }
}