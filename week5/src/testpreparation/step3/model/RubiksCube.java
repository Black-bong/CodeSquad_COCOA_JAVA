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
        Cube blueColorSide = new Cube("B", 3, 3);
        cubeRepository.save(blueColorSide);
        Cube whiteColorSide = new Cube("W", 3, 3);
        cubeRepository.save(whiteColorSide);
        Cube orangeColorSide = new Cube("O", 3, 3);
        cubeRepository.save(orangeColorSide);
        Cube greenColorSide = new Cube("G", 3, 3);
        cubeRepository.save(greenColorSide);
        Cube yellowColorSide = new Cube("Y", 3, 3);
        cubeRepository.save(yellowColorSide);
        Cube redColorSide = new Cube("R", 3, 3);
        cubeRepository.save(redColorSide);
    }

    public void printCube() {
        cubeRepository.printCube();
    }

    public void cubeExit() {
        endScreen();
    }

    public void movingToLeftBottomLine() {
        int cubeKey = 5;
        int cubeLineIndex = 2;
        cubeRepository.leftRotate(cubeKey, cubeLineIndex);
        LOG.info("D'");
    }

    public void movingToRightBottomLine() {
        int cubeKey = 5;
        int cubeLineIndex = 2;
        cubeRepository.rightRotate(cubeKey, cubeLineIndex);
        LOG.info("D");
    }

    public void movingToDownLeftLine() {
        LOG.info("L");
    }

    public void movingToUpLeftLine() {
        int colIndex = 0;
        cubeRepository.upRotate(colIndex);
        LOG.info("L'");
    }

    public void movingToUpRightLine() {
        int colIndex = 2;
        cubeRepository.upRotate(colIndex);
        LOG.info("R");
    }

    public void movingToDownRightLine() {
        LOG.info("R'");
    }

    public void movingToRightTopLine() {
        int cubeKey = 0;
        int cubeLineIndex = 0;
        cubeRepository.rightRotate(cubeKey, cubeLineIndex);
        LOG.info("U'");
    }

    public void movingToLeftTopLine() {
        int cubeKey = 0;
        int cubeLineIndex = 0;
        cubeRepository.leftRotate(cubeKey, cubeLineIndex);
        LOG.info("U");
    }

    public void movingToLeftFront() {
        int cubeKey = 2;
        cubeRepository.reverseRotate(cubeKey);
        LOG.info("F'");
    }

    public void movingToRightFront() {
        int cubeKey = 2;
        cubeRepository.rotate(cubeKey);
        LOG.info("F");
    }

    public void movingToLeftBack() {
        int cubeKey = 4;
        cubeRepository.reverseRotate(cubeKey);
        LOG.info("B");
    }

    public void movingToRightBack() {
        int cubeKey = 4;
        cubeRepository.rotate(cubeKey);
        LOG.info("B'");
    }
}