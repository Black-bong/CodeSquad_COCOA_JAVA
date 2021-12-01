package testpreparation.step3.controller;

import testpreparation.step3.model.RubiksCube;

import java.util.Map;

public class Commend extends RubiksCube {

    public void splitInputString(String inputString) {

    }

    private void createCommend(Map<Integer, Runnable> commendList) {
        commendList.put(0, () -> movingToRightTopLine()); // U'
        commendList.put(1, () -> movingToLeftTopLine()); // U
        commendList.put(2, () -> movingToDownRightLine()); // R'
        commendList.put(3, () -> movingToUpRightLine()); // R
        commendList.put(4, () -> movingToUpLeftLine()); // L'
        commendList.put(5, () -> movingToDownLeftLine()); // L
        commendList.put(6, () -> movingToRightBottomLine()); // D
        commendList.put(7, () -> movingToLeftBottomLine()); // D'
        commendList.put(8, () -> movingToRightFront()); // F
        commendList.put(9, () -> movingToLeftFront()); // F'
        commendList.put(10, () -> movingToRightBack()); // B'
        commendList.put(11, () -> movingToLeftBack()); // B
        commendList.put(12, () -> cubeExit()); // Q
    }
}
