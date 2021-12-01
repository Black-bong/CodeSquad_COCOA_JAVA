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

    private void rotateColClockWise() {

    }

    private void rotateColInverted() {

    }

    private void rotateLowClockWise() {

    }

    private void rotateLowInverted() {

    }

    public void clockWise(int cubeKey) {
        String[][] tempArr = new String[3][3];
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr[i].length; j++) {
                tempArr[j][2 - i] = cubeList.get(cubeKey).getCube()[i][j];
            }
        }
    }

    public void inverted(int cubeKey) {
        for (int i = 0; i < 3; i++) {
            clockWise(cubeKey);
        }
    }
}