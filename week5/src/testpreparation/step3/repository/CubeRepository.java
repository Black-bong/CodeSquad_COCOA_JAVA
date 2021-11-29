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
            sb.append("               ");
            for (int j = 0; j < 3; j++) {
                sb.append(cubeList.get(count).getCube()[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");
    }

    public void replaceCubeLine(int cubeKey, int cubeLineIndex) {
        List<String[]> value = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            value.add(cubeList.get((i % 4) + 1).getCube()[cubeLineIndex]);
        }
        for (int j = 0; j < value.size(); j++) {
            cubeList.get(j+1).getCube()[cubeLineIndex] = value.get(j);
        }
        reverseRotate(cubeKey);
    }

    public void rotate(int cubeKey) {
        String[][] cubeSide = new String[3][3];
        for (int i = 0; i < cubeSide.length; i++) {
            for (int j = 0; j < cubeSide[i].length; j++) {
                cubeSide[j][2 - i] = cubeList.get(cubeKey).getCube()[i][j];
            }
        }
        for (int i = 0; i < cubeSide.length; i++) {
            for (int j = 0; j < cubeSide[i].length; j++) {
                cubeList.get(cubeKey).getCube()[i][j] = cubeSide[i][j];
            }
        }
    }

    public void reverseRotate(int cubeKey) {
        for (int i = 0; i < 2; i++) {
            rotate(cubeKey);
        }
    }
}