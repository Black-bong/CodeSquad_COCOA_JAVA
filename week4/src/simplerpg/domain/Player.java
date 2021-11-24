package simplerpg.domain;

public class Player implements Location {
    private int locationX;
    private int locationY;

    public Player() {

    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    @Override
    public void startLocate(int x, int y) {
        this.locationX = x;
        this.locationY = y;
    }
}