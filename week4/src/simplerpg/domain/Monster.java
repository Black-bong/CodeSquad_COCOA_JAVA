package simplerpg.domain;


import java.util.Random;

public class Monster implements Location {
    private int locationX;
    private int locationY;

    public Monster() {

    }

    @Override
    public void startLocate(int x, int y) {
        Random random = new Random();
        this.locationX = random.nextInt(5);
        this.locationY = random.nextInt(5);
        if (locationX == x && locationY == y) {
            startLocate(x, y);
        }
    }

    public int sameLocate(int x) {
        return Integer.compare(x, locationX);
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }
}