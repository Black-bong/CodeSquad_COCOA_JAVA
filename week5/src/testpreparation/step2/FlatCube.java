package testpreparation.step2;

import testpreparation.step2.domain.Cube;
import testpreparation.step2.resource.Commends;
import testpreparation.step2.resource.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatCube {

    public void start() throws IOException {
        Input input = new Input();
        Map<Integer, Runnable> commendList = new HashMap<>();
        Cube cube = createCube();
        cube.printCube();
        createCommend(cube, commendList);
        while (true) {
            System.out.print("CUBE> ");
            String inputCommend = input.inputString();
            if (inputCommend.equals("Q")) {
                System.out.println("Bye~");
                break;
            }
            splitCommend(inputCommend, commendList);
        }
    }

    private Cube createCube() {
        return new Cube(new String[][]{
                {"R ", "R ", "W "},
                {"G ", "C ", "W "},
                {"G ", "B ", "B "}
        });
    }

    private void createCommend(Cube cube, Map<Integer, Runnable> commendList) {
        commendList.put(0, () -> movingToRightTopLine(cube));
        commendList.put(1, () -> movingToLeftTopLine(cube));
        commendList.put(2, () -> movingToDownRightLine(cube));
        commendList.put(3, () -> movingToUpRightLine(cube));
        commendList.put(4, () -> movingToUpLeftLine(cube));
        commendList.put(5, () -> movingToDownLeftLine(cube));
        commendList.put(6, () -> movingToRightBottomLine(cube));
        commendList.put(7, () -> movingToLeftBottomLine(cube));
    }

    private void splitCommend(String commend, Map<Integer, Runnable> commendList) {
        List<String> values = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < commend.length(); i++) {
            String commends = Character.toString(commend.charAt(i));
            if (commends.equals("'")) {
                String temp = commend.charAt(i - 1) + commends;
                values.set(j - 1, temp);
                continue;
            }
            values.add(Character.toString(commend.charAt(i)));
            j++;
        }
        for (var i : values) {
            commendList.get(Commends.transferCommendID(i)).run();
        }
    }

    private void movingToLeftBottomLine(Cube cube) {
        System.out.println("B'");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeLowIndex = 2;
        for (int i = 0; i < cubeSize; i++) {
            int columnIndex = (i + 1) % cubeSize;
            String bottomLineValue = cube.getCube()[cubeLowIndex][columnIndex];
            replaceBottom[i] = bottomLineValue;
        }
        cube.replaceColCube(cubeLowIndex, replaceBottom);
    }

    private void movingToRightBottomLine(Cube cube) {
        System.out.println("B");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeLowIndex = 2;
        for (int i = 0; i < cubeSize; i++) {
            int columnIndex = (i + 2) % cubeSize;
            String bottomLineValue = cube.getCube()[cubeLowIndex][columnIndex];
            replaceBottom[i] = bottomLineValue;
        }
        cube.replaceColCube(cubeLowIndex, replaceBottom);
    }

    private void movingToDownLeftLine(Cube cube) {
        System.out.println("L");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeCloIndex = 0;
        for (int i = 0; i < cubeSize; i++) {
            int rowIndex = (i + 2) % cubeSize;
            String firstColLineValue = cube.getCube()[rowIndex][cubeCloIndex];
            replaceBottom[i] = firstColLineValue;
        }
        cube.replaceRowCube(cubeCloIndex, replaceBottom);
    }

    private void movingToUpLeftLine(Cube cube) {
        System.out.println("L'");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeCloIndex = 0;
        for (int i = 0; i < cubeSize; i++) {
            int rowIndex = (i + 1) % cubeSize;
            String firstColLineValue = cube.getCube()[rowIndex][cubeCloIndex];
            replaceBottom[i] = firstColLineValue;
        }
        cube.replaceRowCube(cubeCloIndex, replaceBottom);
    }

    private void movingToUpRightLine(Cube cube) {
        System.out.println("R");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeCloIndex = 2;
        for (int i = 0; i < cubeSize; i++) {
            int rowIndex = (i + 1) % cubeSize;
            String firstColLineValue = cube.getCube()[rowIndex][cubeCloIndex];
            replaceBottom[i] = firstColLineValue;
        }
        cube.replaceRowCube(cubeCloIndex, replaceBottom);
    }

    private void movingToDownRightLine(Cube cube) {
        System.out.println("R'");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeCloIndex = 2;
        for (int i = 0; i < cubeSize; i++) {
            int rowIndex = (i + 2) % cubeSize;
            String firstColLineValue = cube.getCube()[rowIndex][cubeCloIndex];
            replaceBottom[i] = firstColLineValue;
        }
        cube.replaceRowCube(cubeCloIndex, replaceBottom);
    }

    private void movingToRightTopLine(Cube cube) {
        System.out.println("U'");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeLowIndex = 0;
        for (int i = 0; i < cubeSize; i++) {
            int columnIndex = (i + 2) % cubeSize;
            String bottomLineValue = cube.getCube()[cubeLowIndex][columnIndex];
            replaceBottom[i] = bottomLineValue;
        }
        cube.replaceColCube(cubeLowIndex, replaceBottom);
    }

    private void movingToLeftTopLine(Cube cube) {
        System.out.println("U");
        String[] replaceBottom = new String[cube.getCubeSize()];
        int cubeSize = cube.getCubeSize();
        int cubeLowIndex = 0;
        for (int i = 0; i < cubeSize; i++) {
            int columnIndex = (i + 1) % cubeSize;
            String bottomLineValue = cube.getCube()[cubeLowIndex][columnIndex];
            replaceBottom[i] = bottomLineValue;
        }
        cube.replaceColCube(cubeLowIndex, replaceBottom);
    }
}