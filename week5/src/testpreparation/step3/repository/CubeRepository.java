package testpreparation.step3.repository;

import testpreparation.step3.domain.Cube;

import java.util.*;

public class CubeRepository {
    private static final CubeRepository instance = new CubeRepository();
    private static final Map<Integer, Cube> cubeList = new HashMap<>();
    private static int sequence = 0;

    public void save(Cube cube) {
        cube.setId(sequence);
        cubeList.put(sequence, cube);
        sequence++;
    }

    public static CubeRepository getInstance() {
        return instance;
    }

    public void printCube() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        topAndBottom(sb, count);
        for (int c = 0; c < 3; c++) {
            center(sb, c);
        }
        count = 5;
        topAndBottom(sb, count);
        System.out.println(sb);
    }

    private void center(StringBuilder sb, int c) {
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(cubeList.get(i).getCube()[c][j]).append("");
            }
            sb.append("");
        }
        sb.append("\n");
    }

    private void topAndBottom(StringBuilder sb, int count) {
        for (int i = 0; i < 3; i++) {
            sb.append("       ");
            for (int j = 0; j < 3; j++) {
                sb.append(cubeList.get(count).getCube()[i][j]).append("");
            }
            sb.append("\n");
        }
    }

    public void left() {

    }

    public void right() {

    }

    public void up(String rotate) {
        int[] cubeKey = {1, 2, 3, 4, 0};
        int lowIndex = 0;
        if (rotate.equals("inverted")) {
            inverted(0);
            rotateClockWise(cubeKey, lowIndex);
        }
        if (rotate.equals("clock")) {
            clockWise(0);
            rotateInverted(cubeKey, lowIndex);
        }
    }

    public void down(String rotate) {
        int[] cubeKey = {1, 2, 3, 4, 5};
        int lowIndex = 2;
        if (rotate.equals("clock")) {
            clockWise(5);
            rotateClockWise(cubeKey, lowIndex);
        }
        if (rotate.equals("inverted")) {
            inverted(5);
            rotateInverted(cubeKey, lowIndex);
        }
    }

    private void rotateClockWise(int[] cubeKey, int lowIndex) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < cubeKey.length - 1; i++) {
            for (int j = 0; j < 3; j++) {
                deque.add(cubeList.get(cubeKey[i]).getCube()[lowIndex][j]);
            }
        }
        for (int j = 0; j < 3; j++) {
            deque.add(deque.poll());
        }
        for (int i = 0; i < cubeKey.length - 1; i++) {
            for (int j = 0; j < 3; j++) {
                cubeList.get(cubeKey[i]).getCube()[lowIndex][j] = deque.poll();
            }
        }
        printCube();
    }

    private void rotateInverted(int[] cubeKey, int lowIndex) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < cubeKey.length - 1; i++) {
            for (int j = 0; j < 3; j++) {
                deque.add(cubeList.get(cubeKey[i]).getCube()[lowIndex][j]);
            }
        }
        for (int j = 0; j < 3; j++) {
            deque.addFirst(deque.pollLast());
        }
        for (int i = 0; i < cubeKey.length - 1; i++) {
            for (int j = 0; j < 3; j++) {
                cubeList.get(cubeKey[i]).getCube()[lowIndex][j] = deque.poll();
            }
        }
        printCube();
    }

    public void front() {

    }

    public void bottom() {

    }

    public void clockWise(int cubeKey) {
        String[][] tempArr = new String[3][3];
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr[i].length; j++) {
                tempArr[j][2 - i] = cubeList.get(cubeKey).getCube()[i][j];
            }
        }
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr[i].length; j++) {
                cubeList.get(cubeKey).getCube()[i][j] = tempArr[i][j];
            }
        }
    }

    public void inverted(int cubeKey) {
        for (int i = 0; i < 3; i++) {
            clockWise(cubeKey);
        }
    }
}