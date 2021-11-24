package simplerpg.domain;

public class Trap implements Location {
    private int locationX;
    private int locationY;

    public Trap() {
    }

    @Override
    public void startLocate(int x, int y) {
        this.locationX = (int) (Math.random() * 5);
        this.locationY = (int) (Math.random() * 5);
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