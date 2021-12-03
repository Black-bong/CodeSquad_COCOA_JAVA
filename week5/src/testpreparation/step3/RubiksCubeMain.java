package testpreparation.step3;

import testpreparation.step3.controller.RubiksCubeController;

import java.io.IOException;


public class RubiksCubeMain {
    public static void main(String[] args) throws IOException {
        RubiksCubeController rubiksCubeController = new RubiksCubeController();
        rubiksCubeController.start();
    }
}