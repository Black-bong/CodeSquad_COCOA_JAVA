package testpreparation.step3;

import testpreparation.step3.model.RubiksCube;

import java.io.IOException;


public class RubiksCubeMain {
    public static void main(String[] args) throws IOException {
        RubiksCube rubiksCube = new RubiksCube();
        rubiksCube.start();
    }
}