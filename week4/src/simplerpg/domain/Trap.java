package simplerpg.domain;

import java.util.Random;

public class Trap implements Location {
    private int locationX;
    private int locationY;

    public Trap() {
    }

    @Override
    public void startLocate(int x, int y) {
        Random random = new Random();
        this.locationX = random.nextInt(5);
        this.locationY = random.nextInt(5);
        if ((x == locationX && y == locationY) || (locationX == 2 && locationY == 2)) {
            startLocate(x, y);
        }
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }
}