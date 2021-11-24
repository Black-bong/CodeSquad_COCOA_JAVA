package simplerpg.domain;

public class Player implements Location {
    private int locationX;
    private int locationY;

    public Player() {
        startLocate();
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    @Override
    public void startLocate() {
        this.locationX = 2;
        this.locationY = 2;
    }
}