package testpreparation.step3.model;

import testpreparation.step3.domain.Cube;
import testpreparation.step3.repository.CubeRepository;
import testpreparation.step3.view.PrintScreen;


public class RubiksCube extends PrintScreen {

    CubeRepository cubeRepository = CubeRepository.getInstance();

    protected void createCube() {
        Cube top = new Cube("⬜", 3, 3);
        cubeRepository.save(top);
        Cube left = new Cube("\uD83D\uDFE7", 3, 3);
        cubeRepository.save(left);
        Cube front = new Cube("\uD83D\uDFE9", 3, 3);
        cubeRepository.save(front);
        Cube right = new Cube("\uD83D\uDFE5", 3, 3);
        cubeRepository.save(right);
        Cube back = new Cube("\uD83D\uDFE6", 3, 3);
        cubeRepository.save(back);
        Cube bottom = new Cube("\uD83D\uDFE8", 3, 3);
        cubeRepository.save(bottom);
    }

    public void downInverted() {
        System.out.println("D");
        cubeRepository.rotateClockWise();
        printCube();
    }

    public void downClockWise() {
        System.out.println("D'");
        cubeRepository.rotateInverted();
        printCube();
    }

    public void leftClockWise() {
        System.out.println("L");
        cubeRepository.left();
        printCube();
    }

    public void leftInverted() {
        System.out.println("L'");
    }

    public void rightClockWise() {
        System.out.println("R");

    }

    public void rightInverted() {
        System.out.println("R'");

    }

    public void upInverted() {
        System.out.println("U'");
    }

    public void upClockWise() {
        System.out.println("U");
    }


    public void frontInverted() {
        System.out.println("F'");

    }


    public void frontClockWise() {
        System.out.println("F");

    }


    public void bottomClockWise() {
        System.out.println("B");

    }


    public void bottomInverted() {
        System.out.println("B'");

    }
}