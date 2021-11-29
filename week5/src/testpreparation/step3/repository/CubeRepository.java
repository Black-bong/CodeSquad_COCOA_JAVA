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
                sb.append(cubeList.get(i).getCube()[c][j]).append(" ");
            }
            sb.append("    ");
        }
        sb.append("\n");
    }

    private void topAndBottom(StringBuilder sb, int count) {
        sb.append("\n");
        for (int i = 0; i < 3; i++) {
            sb.append("          ");
            for (int j = 0; j < 3; j++) {
                sb.append(cubeList.get(count).getCube()[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");
    }

    public void leftRotate(int cubeKey, int cubeLineIndex) {
        List<String[]> value = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            value.add(cubeList.get((i % 4) + 1).getCube()[cubeLineIndex]);
        }
        for (int j = 0; j < value.size(); j++) {
            cubeList.get(j + 1).getCube()[cubeLineIndex] = value.get(j);
        }
        rotate(cubeKey);
    }

    public void rightRotate(int cubeKey, int cubeLineIndex) {
        List<String[]> value = new ArrayList<>();
        value.add(cubeList.get(4).getCube()[cubeLineIndex]);
        for (int i = 0; i < 3; i++) {
            value.add(cubeList.get(i + 1 % 4).getCube()[cubeLineIndex]);
        }
        for (int j = 0; j < value.size(); j++) {
            cubeList.get(j + 1).getCube()[cubeLineIndex] = value.get(j);
        }
        reverseRotate(cubeKey);
    }

    public void upRotate(int cubeKey, int colIndex, int backColIndex) {
        int[] cubeKeys = {0, 2, 5, 4};
        int valueIndex = 0;
        List<String> value = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j > -1; j--) {
                value.add(cubeList.get(cubeKeys[i]).getCube()[j][colIndex]);
            }
        }
        for (int j = 2; j > -1; j--) {
            value.add(cubeList.get(cubeKeys[3]).getCube()[j][backColIndex]);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cubeList.get(cubeKeys[i]).getCube()[j][colIndex] = value.get((valueIndex + 3) % value.size());
                valueIndex++;
            }
        }
        for (int j = 0; j < 3; j++) {
            cubeList.get(cubeKeys[3]).getCube()[j][backColIndex] = value.get((valueIndex + 3) % value.size());
            valueIndex++;
        }
        if (cubeKey == 1) {
            reverseRotate(cubeKey);
        }
        if (cubeKey != 1) {
            rotate(cubeKey);
        }

    }

    public void downRotate(int cubeKey, int colIndex, int backColIndex) {
        int[] cubeKeys = {0, 2, 5, 4};
        int valueIndex = 0;
        List<String> value = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value.add(cubeList.get(cubeKeys[i]).getCube()[j][colIndex]);
            }
        }
        for (int j = 2; j > -1; j--) {
            value.add(cubeList.get(cubeKeys[3]).getCube()[j][backColIndex]);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cubeList.get(cubeKeys[i]).getCube()[j][colIndex] = value.get((valueIndex + 9) % value.size());
                valueIndex++;
            }
        }
        for (int j = 0; j < 3; j++) {
            cubeList.get(cubeKeys[3]).getCube()[j][backColIndex] = value.get((valueIndex + 9) % value.size());
            valueIndex++;
        }
        if (cubeKey == 1) {
            rotate(cubeKey);
        }
        if (cubeKey != 1) {
            reverseRotate(cubeKey);
        }

    }
    //  WWW RRR YYY OOO 012 345 678 91011
    public void frontRotate(int cubeKey) {
        rotate(cubeKey);
        List<String> value = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            value.add(cubeList.get(0).getCube()[2][i]);
        }
        for (int i = 0; i < 3; i++) {
            value.add(cubeList.get(3).getCube()[i][0]);
        }
        for (int i = 2, j = 0; i > -1; i--, j++) {
            value.add(cubeList.get(5).getCube()[0][j]);
        }
        for (int i = 2, j = 0; i > -1; i--, j++) {
            value.add(cubeList.get(1).getCube()[j][2]);
        }
        for (var i : value) {
            System.out.println(i);
        }
        for (int i = 2, j = 0; i > -1; i--, j++) {
            cubeList.get(0).getCube()[2][j] = value.get((j + 9) % value.size());
            cubeList.get(3).getCube()[j][0] = value.get((j + 6) % value.size());
            cubeList.get(5).getCube()[0][i] = value.get((j + 3) % value.size());
            cubeList.get(1).getCube()[i][2] = value.get(j % value.size());
        }
    }

    public void rotate(int cubeKey) {
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

    public void reverseRotate(int cubeKey) {
        for (int i = 0; i < 3; i++) {
            rotate(cubeKey);
        }
    }
}