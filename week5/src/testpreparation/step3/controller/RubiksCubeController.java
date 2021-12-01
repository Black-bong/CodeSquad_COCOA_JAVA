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
        controllerList.put(0, () -> upInverted()); // U'
        controllerList.put(1, () -> upClockWise()); // U
        controllerList.put(2, () -> rightInverted()); // R'
        controllerList.put(3, () -> rightClockWise()); // R
        controllerList.put(4, () -> leftInverted()); // L'
        controllerList.put(5, () -> leftClockWise()); // L
        controllerList.put(6, () -> downInverted()); // D
        controllerList.put(7, () -> downClockWise()); // D'
        controllerList.put(8, () -> frontClockWise()); // F
        controllerList.put(9, () -> frontInverted()); // F'
        controllerList.put(10, () -> bottomInverted()); // B'
        controllerList.put(11, () -> bottomClockWise()); // B
    }
}
