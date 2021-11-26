package simplerpg.domain;

import java.util.Arrays;

public class Map {
    private static final int X_AXIS = 5;
    private static final int Y_AXIS = 5;
    private static final String[][] mapSize = new String[X_AXIS][Y_AXIS];

    public Map() {

    }

    public String[][] createMap() {
        for (String[] strings : mapSize) {
            Arrays.fill(strings, "* ");
        }
        return mapSize;
    }
}