package testpreparation.step3.repository;

import testpreparation.step3.domain.Cube;

import java.util.HashMap;
import java.util.Map;

public class CubeRepository {
    private static final CubeRepository instance = new CubeRepository();
    private static final Map<Integer, Cube> cubeList = new HashMap<>();
    private static int sequence = 0;

    public void save(Cube cube) {
        cube.setId(++sequence);
        cubeList.put(sequence, cube);
    }

    public static CubeRepository getInstance() {
        return instance;
    }

    public void printCube() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        topAndBottom(sb, count);
        for (int c = 0; c < 3; c++) {
            center(sb, c);
        }
        count = 6;
        topAndBottom(sb, count);
        System.out.println(sb);
    }

    private void center(StringBuilder sb, int c) {
        for (int i = 2; i < 6; i++) {
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
}