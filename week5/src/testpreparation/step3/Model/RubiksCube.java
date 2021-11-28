package testpreparation.step3.Model;

import testpreparation.step3.domain.Cube;
import testpreparation.step3.repository.CubeRepository;


public class RubiksCube {

    CubeRepository cubeRepository = CubeRepository.getInstance();

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
}