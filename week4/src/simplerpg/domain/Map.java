package simplerpg.domain;

import simplerpg.resource.SameLocationException;

import java.util.Arrays;

public class Map {
    private static final int xAxis = 5;
    private static final int yAxis = 5;
    private static final String[][] map = new String[xAxis][yAxis];

    public Map() {
        for (String[] strings : map) {
            Arrays.fill(strings, "* ");
        }
        createLocation();
    }

    private void createLocation() {
        Player p = new Player();
        Monster m = new Monster();
        map[p.getLocationX()][p.getLocationY()] = "C ";
        createMonsterLocation(p, m);
    }

    private void createMonsterLocation(Player p, Monster m) {
        try {
            if (m.getLocationX() == p.getLocationX() || m.getLocationY() == p.getLocationY()) {
                throw new SameLocationException();
            }
            map[m.getLocationX()][m.getLocationY()] = "M ";
        } catch (SameLocationException e) {
            System.out.println(e.getMessage());
            Monster newMonster = new Monster();
            map[newMonster.getLocationX()][newMonster.getLocationY()] = "M ";
        }
    }

    public void printMap() {
        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}