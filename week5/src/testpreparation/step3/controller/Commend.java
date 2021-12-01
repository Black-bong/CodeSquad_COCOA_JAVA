package testpreparation.step3.controller;

import testpreparation.step3.model.RubiksCube;
import testpreparation.step3.resource.Commends;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commend extends RubiksCube {


    public void saveCommend(List<String> commandList) {
        Map<Integer, Runnable> controllerList = new HashMap<>();
        createCommendController(controllerList);
        readCommend(commandList, controllerList);
    }

    private void readCommend(List<String> commandList, Map<Integer, Runnable> controllerList) {
        for (String s : commandList) {
            controllerList.get(Commends.transferCommendID(s)).run();
        }
    }

    private void createCommendController(Map<Integer, Runnable> controllerList) {
        controllerList.put(0, () -> movingToRightTopLine()); // U'
        controllerList.put(1, () -> movingToLeftTopLine()); // U
        controllerList.put(2, () -> movingToDownRightLine()); // R'
        controllerList.put(3, () -> movingToUpRightLine()); // R
        controllerList.put(4, () -> movingToUpLeftLine()); // L'
        controllerList.put(5, () -> movingToDownLeftLine()); // L
        controllerList.put(6, () -> movingToRightBottomLine()); // D
        controllerList.put(7, () -> movingToLeftBottomLine()); // D'
        controllerList.put(8, () -> movingToRightFront()); // F
        controllerList.put(9, () -> movingToLeftFront()); // F'
        controllerList.put(10, () -> movingToRightBack()); // B'
        controllerList.put(11, () -> movingToLeftBack()); // B
    }
}
