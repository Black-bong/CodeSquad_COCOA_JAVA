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
                sb.append(cubeList.get(i).getCube()[c][j]);
            }
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

    public void up() {

    }

    public void down() {

    }

    public void front() {

    }

    public void bottom() {

    }

    private void readDeque(Deque<String> deque) {
        for (int cubeKey = 1; cubeKey < cubeList.size() - 1; cubeKey++) {
            for (int col = 0; col < 3; col++) {
                cubeList.get(cubeKey).getCube()[2][col] = deque.poll();
            }
        }
    }

    private void saveDeque(Deque<String> deque) {
        for (int cubeKey = 1; cubeKey < cubeList.size() - 1; cubeKey++) {
            for (int col = 0; col < 3; col++) {
                deque.add(cubeList.get(cubeKey).getCube()[2][col]);
            }
        }
    }

    public void rotateClockWise() {
        Deque<String> deque = new ArrayDeque<>();
        saveDeque(deque);
        for (int i = 0; i < 3; i++) {
            deque.addFirst(deque.pollLast());
        }
        readDeque(deque);
        cubeList.get(5).setCube(clockWise(cubeList.get(5).getCube()));
    }

    public void rotateInverted() {
        Deque<String> deque = new ArrayDeque<>();
        saveDeque(deque);
        for (int i = 0; i < 3; i++) {
            deque.add(deque.poll());
        }
        readDeque(deque);
        cubeList.get(5).setCube(inverted(cubeList.get(5).getCube()));
    }

    public String[][] clockWise(String[][] cube) {
        String[][] tempArr = new String[3][3];
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr[i].length; j++) {
                tempArr[j][2 - i] = cube[i][j];
            }
        }
        return tempArr;
    }

    public String[][] inverted(String[][] cube) {
        String[][] tempArr = new String[3][3];
        for (int i = 0; i < 3; i++) {
            tempArr = clockWise(cube);
        }
        return tempArr;
    }
}