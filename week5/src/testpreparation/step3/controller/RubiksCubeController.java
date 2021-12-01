package testpreparation.step3.controller;

import testpreparation.step3.model.CubeTimer;
import testpreparation.step3.model.RubiksCube;
import testpreparation.step3.resource.Commends;
import testpreparation.step3.resource.Input;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RubiksCubeController extends RubiksCube {

    CubeTimer cubeTimer = CubeTimer.getInstance();

    private int commandCount = 0;
    private boolean inputFlag = true;

    public void start() throws IOException {
        cubeTimer.timeCheck();
        createCube();
        startScreen();
        saveCommend();
    }

    private void saveCommend() throws IOException {
        Input input = new Input();
        List<String> commandList = new LinkedList<>();
        Map<Integer, Runnable> controllerList = new HashMap<>();
        createCommendController(controllerList);
        while (inputFlag) {
            clearCommandList(commandList);
            inputBar();
            input.inputString(commandList);
            readCommend(commandList, controllerList);
        }
    }

    private void clearCommandList(List<String> commandList) {
        if (!commandList.isEmpty()) {
            commandList.clear();
        }
    }

    private void readCommend(List<String> commandList, Map<Integer, Runnable> controllerList) {
        for (String s : commandList) {
            commandCount++;
            if (s.equals("Q")) {
                inputFlag = false;
                endScreen(commandCount, cubeTimer.stopTimer());
                break;
            }
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
