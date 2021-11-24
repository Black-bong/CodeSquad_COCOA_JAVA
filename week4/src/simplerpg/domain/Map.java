package simplerpg.domain;

import java.util.Arrays;

public class Map {
    private static final int xAxis = 5;
    private static final int yAxis = 5;
    private static final String[][] map = new String[xAxis][yAxis];

    public Map() {

    }

    public String[][] createMap() {
        for (String[] strings : map) {
            Arrays.fill(strings, "* ");
        }
        return map;
    }
}